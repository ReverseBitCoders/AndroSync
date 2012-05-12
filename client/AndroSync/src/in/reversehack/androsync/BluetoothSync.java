package in.reversehack.androsync;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class BluetoothSync extends Activity {

	BluetoothAdapter mBluetoothAdap = null;
	private ArrayAdapter<String> mPairedDevicesArrayAdapter;
	private ArrayAdapter<String> mNewDevicesArrayAdapter;

	private static final int REQUEST_ENABLE_BT = 3; // constant value has to be
													// > 0
	public static String EXTRA_DEVICE_ADDRESS = "device_address";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bluetooth_device_list);

		mBluetoothAdap = BluetoothAdapter.getDefaultAdapter();
		if (mBluetoothAdap == null) {
			Log.d("AndroSyncBT", "Bluetooth Not Found!");

		} else {
			Log.d("AndroSyncBT", "Bluetooth found!");
		}

		Button scanButton = (Button) findViewById(R.id.buttonScanForDevices);
		scanButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bluetoothDiscover();

			}
		});
		mPairedDevicesArrayAdapter = new ArrayAdapter<String>(this,
				R.layout.bluetooth_device_name);
		mNewDevicesArrayAdapter = new ArrayAdapter<String>(this,
				R.layout.bluetooth_device_name);

		ListView pairedListView = (ListView) findViewById(R.id.listViewPairedDevices);
		pairedListView.setAdapter(mPairedDevicesArrayAdapter);
		pairedListView.setOnItemClickListener(mDeviceClickListener);

		ListView newDevicesListView = (ListView) findViewById(R.id.listViewNonPairedDevices);
		newDevicesListView.setAdapter(mNewDevicesArrayAdapter);
		newDevicesListView.setOnItemClickListener(mDeviceClickListener);

		// Register for broadcasts when a device is discovered
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		this.registerReceiver(mBroadCastReceiver, filter);

		// Register for broadcasts when discovery has finished
		filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		this.registerReceiver(mBroadCastReceiver, filter);

		// Get a set of currently paired devices
		Set<BluetoothDevice> pairedDevices = mBluetoothAdap.getBondedDevices();

		if (pairedDevices.size() > 0) {
			findViewById(R.id.textViewPairedDevices)
					.setVisibility(View.VISIBLE);
			for (BluetoothDevice device : pairedDevices) {
				mPairedDevicesArrayAdapter.add(device.getName() + "\n"
						+ device.getAddress());
			}
		} else {
			String noDevices = getResources().getText(
					R.string.StringNoBTDevicesPaired).toString();
			mPairedDevicesArrayAdapter.add(noDevices);
		}

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		if (!mBluetoothAdap.isEnabled()) {
			Intent enableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);

		}
	}

	public void bluetoothDiscover() {

		setProgressBarIndeterminateVisibility(true);
		setTitle(R.string.scanning);
		if (mBluetoothAdap.isDiscovering()) {
			mBluetoothAdap.cancelDiscovery();
		}
		mBluetoothAdap.startDiscovery();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (mBluetoothAdap != null) {
			mBluetoothAdap.cancelDiscovery();
		}
		this.unregisterReceiver(mBroadCastReceiver);
	}

	private OnItemClickListener mDeviceClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> av, View v, int arg2, long arg3) {
			// TODO Auto-generated method stub
			mBluetoothAdap.cancelDiscovery();

			String info = ((TextView) v).getText().toString();
			String address = info.substring(info.length() - 17);

			Intent intent = new Intent();
			intent.putExtra(EXTRA_DEVICE_ADDRESS, address);

			setResult(Activity.RESULT_OK, intent);
			finish();

		}
	};

	private final BroadcastReceiver mBroadCastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String action = intent.getAction();
			// When discovery finds a device
			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				BluetoothDevice device = intent
						.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				if (device.getBondState() != device.BOND_BONDED) {
					mNewDevicesArrayAdapter.add(device.getName() + "\n"
							+ device.getAddress());

				} else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED
						.equals(action)) {
					setProgressBarIndeterminateVisibility(false);
					setTitle(R.string.stringSelectDevice);
					if (mNewDevicesArrayAdapter.getCount() == 0) {
						String noDevicesFound = getResources().getText(
								R.string.stringNoDevicesFound).toString();
						mNewDevicesArrayAdapter.add(noDevicesFound);
					}
				}
			}
		}
	};

}
