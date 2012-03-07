package in.reversehack.androsync;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AndroSyncActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_start);

		Button buttonSyncContacts = (Button) findViewById(R.id.buttonSyncContacts);
		Button buttonSyncSMS = (Button) findViewById(R.id.buttonSyncSms);

		buttonSyncContacts.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Log.d("AndroSync", "Clicked Sync Contacts");

				String actionOfIntent = "android.intent.action.showSyncContacts";
				Intent syncContactIntent = new Intent(actionOfIntent);
				startActivity(syncContactIntent);

			}
		});

		buttonSyncSMS.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("AndroSync", "Clicked Sync sms");

				String actionOfIntent = "android.intent.action.SmsSync";
				Intent syncSmsIntent = new Intent(actionOfIntent);
				startActivity(syncSmsIntent);

			}
		});

	}

}
