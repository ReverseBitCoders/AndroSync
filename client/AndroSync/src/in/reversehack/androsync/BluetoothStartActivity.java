package in.reversehack.androsync;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BluetoothStartActivity extends Activity {
	// Tag for debug log
	public static final String TAG = "BluetoothStartAcitivity";
	public static final Boolean D = true;

	// Constants for messages send using handlers, if any.
	public static final int MESSAGE_STATE_CHANGE = 1;
	public static final int MESSAGE_READ = 2;
	public static final int MESSAGE_WRITE = 3;
	public static final int MESSAGE_DEVICE_NAME = 4;
	public static final int MESSAGE_TOAST = 5;

	// BLUETOOTH SERVICE CODES AND INTENTS

	private static final int REQUEST_ENABLE_BT = 3;
	private static final int REQUEST_CONNECT_DEVICE_SECURED = 1;
	private static final int REQUEST_CONNECT_DEVICE_INSECURED = 2;

	private BluetoothAdapter mBluetoothAdapter = null;
	private BluetoothCommunicationService mBluetoothCommunicationService = null;
	BluetoothClientConnector mBluetoothClientConnector = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		if (D)
			Log.d(TAG, "++OnCreate method invoked++");
		setContentView(R.layout.bluetooth_start);
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		if (mBluetoothAdapter == null) {
			Log.d(TAG, "++BT adapter not found++");
			Toast.makeText(this, "Bluetooth is not available",
					Toast.LENGTH_LONG).show();
			finish();
		}

	}

	@Override
	protected void onStart() {

		super.onStart();
		Log.d(TAG, "++onStart Method ++");
		if (!mBluetoothAdapter.isEnabled()) {
			Intent enableBtIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
		} else {
			if (mBluetoothCommunicationService == null)
				setupCommunication();
		}
	}

	private void setupCommunication() {
		// TODO Auto-generated method stub

		Button buttonGetDeviceList = (Button) findViewById(R.id.buttonBluetoothCallDeviceList);
		buttonGetDeviceList.setOnClickListener(new OnClickListener() {
			// public Intent serverIntent = null;

			@Override
			public void onClick(View v) {
				Intent serverIntent = new Intent(BluetoothStartActivity.this,
						BluetoothDeviceList.class);
				startActivityForResult(serverIntent,
						REQUEST_CONNECT_DEVICE_SECURED);

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		// super.onActivityResult(requestCode, resultCode, data);
		Log.d(TAG, "++OnActivityResult++");
		switch (requestCode) {
		case REQUEST_ENABLE_BT:
			if (resultCode == Activity.RESULT_OK) {
				setupCommunication();
			} else {
				Log.d(TAG, "BT not enabled.. ");
			}
		case REQUEST_CONNECT_DEVICE_SECURED:
			if (resultCode == Activity.RESULT_OK) {
				connectDevice(data, true);
			}
			break;
		case REQUEST_CONNECT_DEVICE_INSECURED:
			// When DeviceListActivity returns with a device to connect
			if (resultCode == Activity.RESULT_OK) {
				connectDevice(data, false);
			}
			break;

		}

	}

	private void connectDevice(Intent data, boolean b) {
		String deviceAddress = data.getExtras().getString(
				BluetoothDeviceList.EXTRA_DEVICE_ADDRESS);
		BluetoothDevice device = mBluetoothAdapter
				.getRemoteDevice(deviceAddress);
		mBluetoothClientConnector = new BluetoothClientConnector(device);

	}

}
