package in.reversehack.androsync;

import in.reversehack.androsync.R.string;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
=======
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
>>>>>>> testing
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * @author akshay
 * 
 */
public class SyncContactsActivity extends Activity {

<<<<<<< HEAD
	public ArrayList<ContactInfoAccumulator> contactDataList = new ArrayList<ContactInfoAccumulator>(2);
	public List<NameValuePair> contactNameValuePair = new ArrayList<NameValuePair>();
	public String tempNumber = new String();
	ContactHttpPostActivity startServiceHttp = new ContactHttpPostActivity();
	
=======
	public ArrayList<ContactInfoAccumulator> contactDataList = new ArrayList<ContactInfoAccumulator>(
			2);
	public List<NameValuePair> contactNameValuePair = new ArrayList<NameValuePair>();
	public String tempNumber = new String();

	public String[] contactNames = new String[100];
	public String[] contactNames2 = new String[100];
	public String temp = new String();

>>>>>>> testing
	ContactInfoAccumulator contactDataArray = new ContactInfoAccumulator();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sync_contacts);
		getContactNumbers();
<<<<<<< HEAD
<<<<<<< HEAD
		startServiceHttp.onCreate(savedInstanceState);
		
=======
		startActivity(new Intent(this, ContactListActivity.class));
>>>>>>> testing
=======
		//startActivity(new Intent(this, ContactListActivity.class));
>>>>>>> testing
	}

	public void getContactNumbers() {
		int i = 0;
		ContentResolver contactContentResolver = getContentResolver();

		Cursor contactCursor = contactContentResolver.query(
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

		if (contactCursor.getCount() > 0) {
			/**
			 * at this point the cursor pointer is set to -1 hence we use the
			 * following while statement which auto increments the cursor
			 * pointer to next ie 0.
			 */
			while (contactCursor.moveToNext()) {
<<<<<<< HEAD
				
				ContactInfoAccumulator contactData = new ContactInfoAccumulator(); // new object created here. 
				
=======

				ContactInfoAccumulator contactData = new ContactInfoAccumulator(); // new
																					// object
																					// created
																					// here.

>>>>>>> testing
				String contactId = contactCursor.getString(contactCursor
						.getColumnIndex(ContactsContract.Contacts._ID));

				String contactName = contactCursor
						.getString(contactCursor
								.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
<<<<<<< HEAD
				
			contactData.setContactName(contactName); //setting contact name into data structure
				
=======

				contactData.setContactName(contactName); // setting contact name
															// into data
															// structure

				contactData.setContactID(contactId);

<<<<<<< HEAD
				contactNames[i] = contactName;
>>>>>>> testing
=======
				//contactNames[i] = contactName;
>>>>>>> testing

				if (Integer
						.parseInt(contactCursor.getString(contactCursor
								.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {

					Cursor multipleContactCursor = contactContentResolver
							.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
									null,
									ContactsContract.CommonDataKinds.Phone.CONTACT_ID
<<<<<<< HEAD
											+ "=?", new String[] { contactId },
									null);
					
					/*
					 * http://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
=======
											.toString() + "=?",
									new String[] { contactId }, null);

					/*
					 * http://docs.oracle.com/javase/tutorial/jdbc/basics/prepared
					 * .html
>>>>>>> testing
					 */

					while (multipleContactCursor.moveToNext()) {

						String multPhoneNumber = multipleContactCursor
								.getString(multipleContactCursor
										.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

						contactData.setContactNumber(multPhoneNumber);
						Log.d("AndroSync",
								"number is .. "
										+ contactData.getContactNumber());

					}
					temp = contactData.getContactNumber().toString();
					//Log.d("display temp", temp);
					//contactNames2[i] = contactNames+"\n"+temp;
					//Log.d("display string", contactNames2[i]);
					//i++;

					contactDataList.add(contactData);
<<<<<<< HEAD
					tempNumber = contactData.getContactNumber().toString();
					contactNameValuePair.add(new BasicNameValuePair(contactName,tempNumber));
					multipleContactCursor.close();
				}
				
				Toast.makeText(this, "Name:" + contactData.getContactName()+"  Number:"+contactData.getContactNumber(), Toast.LENGTH_SHORT).show();					
			
			} //temporary contactData objects gets destroyed here. 
=======

					Log.d("androSync", contactName + "number contact.. "
							+ temp);

					multipleContactCursor.close();
				}

				Toast.makeText(
						this,
						"Name:" + contactData.getContactName() + "  Number:"
								+ contactData.getContactNumber(),
						Toast.LENGTH_SHORT).show();
				Log.d("androSync", "reached last");

			} // contactData object destroyed here.
>>>>>>> testing
		}

	}
}
