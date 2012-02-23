package in.reversehack.androsync;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AndroSyncActivity extends Activity implements OnClickListener {
	Button buttonSyncContacts;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_start);

		buttonSyncContacts = (Button) findViewById(R.id.buttonSyncContacts);

		buttonSyncContacts.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Log.d("androSYnc activity", "clicked on contact sync button");
		Toast.makeText(this, R.string.stringToastContactSync, Toast.LENGTH_LONG)
				.show();

	}
}