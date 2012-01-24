package in.reversehack.androsync;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class AndroSyncMain extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	ImageButton imageButtonSyncContacts;
    	Button buttonSyncAll;
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_start);
        
        imageButtonSyncContacts = (ImageButton) findViewById(R.id.imageButtonSyncContacts);
        imageButtonSyncContacts.setOnClickListener(this);
        
        buttonSyncAll = (Button) findViewById(R.id.buttonSyncAll);
        buttonSyncAll.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(this, R.string.stringToastSyncWait, Toast.LENGTH_LONG).show();
		
	}

}