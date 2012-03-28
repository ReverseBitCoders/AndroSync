package in.reversehack.androsync;

import java.io.IOException;
import java.util.UUID;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

public class BluetoothClientConnector extends Thread {

	private final BluetoothSocket mmSocket = null;
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
			return;
		}

		// Do work to manage the connection (in a separate thread)
		mmManageClientSocket = new ManageConnectedClientSocket(mmSocket);

	}

	public void cancel() {
		try {
			mmSocket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
