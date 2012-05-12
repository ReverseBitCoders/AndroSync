package in.reversehack.androsync;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.MonthDisplayHelper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BluetoothActivity extends Activity {
	private BluetoothAdapter mBluetoothAdapter;
	private static final int REQUEST_ENABLE_BT = 1;
	private Set<BluetoothDevice> pairedDevices = null;
	private ArrayAdapter<String> mPairedDevicesArrayAdapter = new ArrayAdapter<String>(
			this, R.layout.bluetooth_device_name);
	private connectAsClient mConnectAsClient;

	/*
	 * private void callWriteMethod(byte[] data) {
	 * 
	 * }
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bluetooth_start);

		ListView mPairedListView = (ListView) findViewById(R.id.listViewPairedDevices);
		mPairedListView.setAdapter(mPairedDevicesArrayAdapter);
		mPairedListView.setOnItemClickListener(mOnDeviceClickListener);

		getBluetoothAdapter();
		enableBluetoothAdapter();
		queryPairedDevices();

	}

	private OnItemClickListener mOnDeviceClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> adapterView, View v, int arg2,
				long arg3) {

			mBluetoothAdapter.cancelDiscovery();

			String mDeviceName = ((TextView) v).getText().toString();
			String mDeviceAddress = mDeviceName
					.substring(mDeviceName.length() - 17);
			BluetoothDevice connectToThisDevice = mBluetoothAdapter
					.getRemoteDevice(mDeviceAddress);
			mConnectAsClient = new connectAsClient(connectToThisDevice);

		}

	};

	private void queryPairedDevices() {
		this.pairedDevices = mBluetoothAdapter.getBondedDevices();
		if (pairedDevices.size() > 0) {
			for (BluetoothDevice device : pairedDevices) {
				mPairedDevicesArrayAdapter.add(device.getName() + "\n"
						+ device.getAddress());
			}
		}
		displayDevices();
	}

	private void displayDevices() {
		// code to display devices in listview and
		// set onClickListener comes here.

	}

	private void getBluetoothAdapter() {
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

	}

	private void enableBluetoothAdapter() {
		if (!mBluetoothAdapter.isEnabled()) {
			Intent enableBTAdapter = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBTAdapter, REQUEST_ENABLE_BT);
		}

	}

	private class connectAsClient extends Thread {
		private final UUID MY_UUID = UUID
				.fromString("a3f7f43a-8005-40b2-9584-404dbc1ddbce");
		private final BluetoothSocket mmSocket;
		private final BluetoothDevice mmDevice;
		private ManageConnectedThread mManageConnectedThread = null;

		public connectAsClient(BluetoothDevice device) {
			BluetoothSocket tempSocket = null;
			this.mmDevice = device;
			try {
				tempSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
			} catch (IOException e) {
				// some code to catch the exception comes here.
			}
			this.mmSocket = tempSocket;

		} // constructor ends here.

		@Override
		public void run() {
			super.run();
			mBluetoothAdapter.cancelDiscovery();
			try {
				mmSocket.connect(); // /tries to connect the device to other
									// device.
			} catch (IOException closeSocketException) {
				try {
					mmSocket.close();
				} catch (IOException socketCloseException) {
					// handle exceptions for socket close.
				}
				return;
			}

			this.mManageConnectedThread = new ManageConnectedThread(mmSocket);

		}

		public void cancel() {
			try {
				this.mmSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}// class connectToClient ends here.

	private class ManageConnectedThread extends Thread {
		private static final int MESSAGE_READ = 0;
		private final BluetoothSocket mmSocket;
		private final InputStream mmInStream;
		private final OutputStream mmOutStream;
		Handler mHandler = null;

		public ManageConnectedThread(BluetoothSocket socket) {
			this.mmSocket = socket;
			InputStream tempInputStream = null;
			OutputStream tempOutStream = null;
			try {
				tempInputStream = socket.getInputStream();
				tempOutStream = socket.getOutputStream();
			} catch (IOException e) {
				// Handle io exception
			}

			mmInStream = tempInputStream;
			mmOutStream = tempOutStream;
		}

		@Override
		public void run() {
			super.run();
			byte[] buffer = new byte[1024];
			int bytesInt;
			while (true) {
				try {
					// Reading from the input stream
					bytesInt = mmInStream.read(buffer);
					mHandler.obtainMessage(MESSAGE_READ, bytesInt, -1, buffer)
							.sendToTarget();

				} catch (IOException e) {
					// handle io exception
					break;
				}
			}
		}

		public void write(byte[] bytes) { // byte is an array of native datatype
											// byte and not Byte of java.lang
			try {
				this.mmOutStream.write(bytes);
			} catch (IOException e) {
				// TODO: handle exception in some way
			}

		}

		public void cancel() {
			try {
				mmSocket.close();
			} catch (IOException e) {
				// TODO: handle exception in some way
			}
		}

	}// manageconnectedthread class closes here

}// outermost class closes here.
