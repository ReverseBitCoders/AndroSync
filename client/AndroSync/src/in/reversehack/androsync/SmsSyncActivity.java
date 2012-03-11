package in.reversehack.androsync;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SmsSyncActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_sync);

		Button buttonSyncInbox = (Button) findViewById(R.id.buttonSyncInbox);
		Button buttonSyncSentBox = (Button) findViewById(R.id.buttonSyncSentbox);
		Button buttonSyncDrafts = (Button) findViewById(R.id.buttonSyncDrafts);

		buttonSyncInbox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("AndroSync", "Clicked Sync sms inbox");

				String actionOfIntent = "android.intent.action.SmsSyncInbox";
				Intent syncSmsIntent = new Intent(actionOfIntent);
				startActivity(syncSmsIntent);

			}
		});

		buttonSyncSentBox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("AndroSync", "Clicked Sync sms sent");

				String actionOfIntent = "android.intent.action.SmsSyncSent";
				Intent syncSmsIntent = new Intent(actionOfIntent);
				startActivity(syncSmsIntent);

			}
		});

		buttonSyncDrafts.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("AndroSync", "Clicked Sync sms draftnt");

				String actionOfIntent = "android.intent.action.SmsSyncDraft";
				Intent syncSmsIntent = new Intent(actionOfIntent);
				startActivity(syncSmsIntent);

			}
		});

	}

}
