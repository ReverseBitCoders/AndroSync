package in.reversehack.androsync;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class SmsSyncActivity extends ListActivity {

	private ListAdapter adapter;
	private static final Uri SMS_INBOX_URI = Uri.parse("content://sms/inbox");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		displaySms();

	}

	public void displaySms() {
		ContentResolver sms_cr = getContentResolver();
		Cursor sms_cursor = sms_cr.query(SMS_INBOX_URI, null, null, null, null);
		startManagingCursor(sms_cursor);

		String[] columns = new String[] { "body" };
		int[] names = new int[] { R.id.inbox_rows };

		adapter = new SimpleCursorAdapter(this, R.layout.sms_list_view,
				sms_cursor, columns, names);

		setListAdapter(adapter);
	}

}
