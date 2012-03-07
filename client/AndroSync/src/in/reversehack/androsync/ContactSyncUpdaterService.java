package in.reversehack.androsync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ContactSyncUpdaterService extends Service {

<<<<<<< HEAD
		private static final String TAG = ContactSyncUpdaterService.class.getSimpleName();
=======
	private static final String TAG = ContactSyncUpdaterService.class
			.getSimpleName();
	ContactHttpPostActivity startServiceHttp = new ContactHttpPostActivity();

>>>>>>> testing
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
<<<<<<< HEAD
		Log.d(TAG,"Service created. ");
=======
		startServiceHttp.startHttpServiceMethod();
		Log.d(TAG, "Service created. ");
>>>>>>> testing
	}

	@Override
	public void onStart(Intent intent, int startId) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Log.d(TAG,"Service started. ");
=======
		super.onStart(intent, startId);
		startServiceHttp.startHttpServiceMethod();
		Log.d(TAG, "Service started. ");
>>>>>>> testing
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
<<<<<<< HEAD
		Log.d(TAG,"Service destroyed. ");
=======
		Log.d(TAG, "Service destroyed. ");
>>>>>>> testing
	}

}
