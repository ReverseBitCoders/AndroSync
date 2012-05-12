package in.reversehack.androsync;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.bluetooth.BluetoothSocket;
import android.util.Log;

public class ManageConnectedClientSocket extends Thread {
	private final BluetoothSocket mmSocket;
	private static final String TAG = "BTConnClient";
	private final InputStream mmInputStream;
	private final OutputStream mmOutputStream;

	public ManageConnectedClientSocket(BluetoothSocket socket) {
		this.mmSocket = socket;
		InputStream tempIn = null;
		OutputStream tempOut = null;

		try {
			tempIn = socket.getInputStream();
			tempOut = socket.getOutputStream();

		} catch (IOException e) {
			Log.d(TAG, "Socket read/write screwed up!");
		}

		mmInputStream = tempIn;
		mmOutputStream = tempOut;

	}

	public void run() {
		byte[] buffer = new byte[1024];
		int bytes;
		// keep listening to input stream until an exception occurs
		while (true) {
			try {
				// read from input stream
				bytes = mmInputStream.read(buffer);
				// send the obtained bytes to the UI activity
				/*mHandler.obtainMessage(MESSAGE_READ, bytes, -1, buffer)
						.sendTotarget();*/
				
				//Log.D(TAG,toString(bytes));

			} catch (IOException e) {
				break;
			}
		}
	}

	public void write(byte[] bytes) {
		try {
			mmOutputStream.write(bytes);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public void cancel() {
		try {
			mmSocket.close();
		} catch (IOException e) {
			// TODO: handle exception

		}
	}

}
