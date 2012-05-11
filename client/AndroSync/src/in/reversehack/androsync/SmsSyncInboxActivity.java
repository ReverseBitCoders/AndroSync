package in.reversehack.androsync;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SmsSyncInboxActivity extends ListActivity {

	private ListAdapter adapter;
	private static final Uri SMS_INBOX_URI = Uri.parse("content://sms/inbox");
	private ArrayList<SmsDataAccumulator> smsNumberBodyPair = new ArrayList<SmsDataAccumulator>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		displayInboxSms();

	}

	public void displayInboxSms() {
		ContentResolver sms_cr = getContentResolver();

		Cursor sms_cursor = sms_cr.query(SMS_INBOX_URI, new String[] { "_id",
				"thread_id", "address", "person", "date", "body" }, null, null,
				null);
		startManagingCursor(sms_cursor);

		String[] columns = new String[] { "address", "body", "date" };

		int[] names = new int[] { R.id.inbox_sender_rows, R.id.inbox_rows,
				R.id.inbox_rows_date };

		adapter = new SimpleCursorAdapter(this, R.layout.sms_list_view,
				sms_cursor, columns, names);
		setListAdapter(adapter);

		// storing data into accumulator

		sms_cursor.moveToFirst();
		while (sms_cursor.moveToNext()) {
			String smsSenderPhoneNumber = sms_cursor.getString(sms_cursor
					.getColumnIndex("address"));
			String smsBody = sms_cursor.getString(sms_cursor
					.getColumnIndex("body"));

			SmsDataAccumulator tempDataObj = new SmsDataAccumulator();

			tempDataObj.setSmsContactNumber(smsSenderPhoneNumber);
			tempDataObj.setSmsBody(smsBody);

			Log.d("CURSOR_COLS", "Phone:" + smsSenderPhoneNumber + "   SMS:"
					+ smsBody);
			smsNumberBodyPair.add(tempDataObj);
	
		}

	}
};