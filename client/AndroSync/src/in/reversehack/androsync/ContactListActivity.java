package in.reversehack.androsync;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactListActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("androSync", "reached here2");
		SyncContactsActivity contactAct = new SyncContactsActivity();
		//Log.d("The name is... ", contactAct.contactNames[1]);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_view, contactAct.contactNames));
		
		Log.d("androSync", "reached here3");
		
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		Log.d("androSync", "reached here4");
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.d("androSync", "reached here5");
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();

			}
		});
		Log.d("androSync", "reached here6");

	}

}
