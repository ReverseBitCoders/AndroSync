package in.reversehack.androsync;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class SmsSyncDraftActivity extends ListActivity {

	private ListAdapter adapter;
	private static final Uri SMS_DRAFT_URI = Uri.parse("content://sms/draft");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		displaySentSms();

	}

	public void displaySentSms() {
		ContentResolver sms_cr = getContentResolver();
		Cursor sms_cursor = sms_cr.query(SMS_DRAFT_URI, new String[] { "_id",
				"thread_id", "address", "person", "date", "body" }, null, null, null);
		startManagingCursor(sms_cursor);

		String[] columns = new String[] {"address", "body","date" };

		int[] names = new int[] { R.id.inbox_sender_rows, R.id.inbox_rows,R.id.inbox_rows_date };

		adapter = new SimpleCursorAdapter(this, R.layout.sms_list_view,
				sms_cursor, columns, names);

		setListAdapter(adapter);
	}

}
