package in.reversehack.androsync;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AndroSyncActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_start);
		
		Button buttonSyncContacts = (Button)findViewById(R.id.buttonSyncContacts);
		Button buttonSyncSMS = (Button)findViewById(R.id.buttonSyncSms);
		
		//on click listener for sync contacts button
		buttonSyncContacts.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(this, R.string.stringToastContactSync,Toast.LENGTH_SHORT).show();
				Log.d("AndroSync", "Clicked Sync Contacts");

				String actionOfIntent = "android.intent.action.showSyncContacts";
				Intent syncContactIntent = new Intent(actionOfIntent);
				startActivity(syncContactIntent);

			}
		});

	}

}