package in.reversehack.androsync;

import in.reversehack.androsync.R.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

/**
 * @author akshay
 * 
 */
public class SyncContactsActivity extends Activity {

	public ArrayList<ContactInfoAccumulator> contactDataList = new ArrayList<ContactInfoAccumulator>(
			2);
	public List<NameValuePair> contactNameValuePair = new ArrayList<NameValuePair>();
	public String tempNumber = new String();

	public static String[] contactNames = new String[800];

	ContactInfoAccumulator contactDataArray = new ContactInfoAccumulator();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sync_contacts);
		getContactNumbers();
		startActivity(new Intent(this, ContactListActivity.class));
	}

	public void getContactNumbers() {
		int i = 0;
		ContentResolver contactContentResolver = getContentResolver();
		Cursor contactCursor = contactContentResolver.query(
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		if (contactCursor.getCount() > 0) {
			while (contactCursor.moveToNext()) {

				ContactInfoAccumulator contactData = new ContactInfoAccumulator(); // new
																					// object
																					// created
																					// here.

				String contactId = contactCursor.getString(contactCursor
						.getColumnIndex(ContactsContract.Contacts._ID));
				String contactName = contactCursor
						.getString(contactCursor
								.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

				contactData.setContactName(contactName); // setting contact name
															// into data
															// structure
				
				contactData.setContactID(contactId);

				if (Integer
						.parseInt(contactCursor.getString(contactCursor
								.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {

					Cursor multipleContactCursor = contactContentResolver
							.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
									null,
									ContactsContract.CommonDataKinds.Phone.CONTACT_ID.toString()
											+ "=?", new String[] { contactId },
									null);

					/*
					 * http://docs.oracle.com/javase/tutorial/jdbc/basics/prepared
					 * .html
					 */

					while (multipleContactCursor.moveToNext()) {

						String multPhoneNumber = multipleContactCursor
								.getString(multipleContactCursor
										.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

						contactNames[i] = contactName;
						i++;
						contactData.setContactNumber(multPhoneNumber);
						Log.d("AndroSync",
								"number is .. "
										+ contactData.getContactNumber());

					}
					contactDataList.add(contactData);

					tempNumber = contactData.getContactNumber().toString();

					contactNameValuePair.add(new BasicNameValuePair(
							contactName, tempNumber));
					Log.d("androSync", contactName + "number contact.. "
							+ tempNumber);
					Log.d("nameValuePair", contactNameValuePair.toString());
					multipleContactCursor.close();
				}

				Toast.makeText(
						this,
						"Name:" + contactData.getContactName() + "  Number:"
								+ contactData.getContactNumber(),
						Toast.LENGTH_SHORT).show();

			}
		}

	}

}
