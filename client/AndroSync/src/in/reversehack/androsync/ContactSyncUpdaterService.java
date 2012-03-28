package in.reversehack.androsync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ContactSyncUpdaterService extends Service {

	private static final String TAG = ContactSyncUpdaterService.class
			.getSimpleName();
	ContactHttpPostActivity startServiceHttp = new ContactHttpPostActivity();

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		startServiceHttp.startHttpServiceMethod();
		Log.d(TAG, "Service created. ");
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		startServiceHttp.startHttpServiceMethod();
		Log.d(TAG, "Service started. ");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(TAG, "Service destroyed. ");
	}

}
