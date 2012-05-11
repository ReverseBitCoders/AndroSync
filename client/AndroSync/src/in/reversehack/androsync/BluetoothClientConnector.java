package in.reversehack.androsync;

import java.io.IOException;
import java.util.UUID;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

public class BluetoothClientConnector extends Thread {

	private BluetoothSocket mmSocket = null;
	private final BluetoothDevice mmDevice;
	private static final UUID MY_UUID = UUID
			.fromString("a3f7f43a-8005-40b2-9584-404dbc1ddbce");
	ManageConnectedClientSocket mmManageClientSocket;

	public BluetoothClientConnector(BluetoothDevice bluetoothDeviceToBeConnected) {
		BluetoothSocket temp = null;
		mmDevice = bluetoothDeviceToBeConnected;

		try {
			temp = bluetoothDeviceToBeConnected
					.createRfcommSocketToServiceRecord(MY_UUID);
		} catch (IOException connectionException) {
			try {
				mmSocket.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
			mmSocket = temp;
			// return;
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BluetoothDeviceList foo = new BluetoothDeviceList();
		
		foo.mBluetoothAdap.cancelDiscovery();
		try {
			mmSocket.connect();

		} catch (Exception e) {
			try {
				mmSocket.close();
			} catch (Exception e2) {

			}

		}

		return;
	}

	public void cancel() {
		try {
			mmSocket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
