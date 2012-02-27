package in.reversehack.androsync;

import in.reversehack.androsync.R.string;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

public class SyncContactsActivity extends Activity {

	public ArrayList<ContactInfoAccumulator> contactDataList = new ArrayList<ContactInfoAccumulator>(2);
	public List<NameValuePair> contactNameValuePair = new ArrayList<NameValuePair>();
	public String tempNumber = new String();
	
	
	ContactInfoAccumulator contactDataArray = new ContactInfoAccumulator();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sync_contacts);
		getContactNumbers();
		ContactSyncUpdaterService startUpdaterService = new ContactSyncUpdaterService();
		startUpdaterService.onCreate();
	}

	public void getContactNumbers() {

		ContentResolver contactContentResolver = getContentResolver();
		Cursor contactCursor = contactContentResolver.query(
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		if (contactCursor.getCount() > 0) {
			while (contactCursor.moveToNext()) {
				
				ContactInfoAccumulator contactData = new ContactInfoAccumulator(); // new object created here. 
				
				String contactId = contactCursor.getString(contactCursor
						.getColumnIndex(ContactsContract.Contacts._ID));
				String contactName = contactCursor
						.getString(contactCursor
								.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				
			contactData.setContactName(contactName); //setting contact name into data structure
				

				if (Integer
						.parseInt(contactCursor.getString(contactCursor
								.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {

					Cursor multipleContactCursor = contactContentResolver
							.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
									null,
									ContactsContract.CommonDataKinds.Phone.CONTACT_ID
											+ "=?", new String[] { contactId },
									null);
					
					/*
					 * http://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
					 */

					while (multipleContactCursor.moveToNext()) {
						
						String multPhoneNumber = multipleContactCursor
								.getString(multipleContactCursor
										.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
						
						contactData.setContactNumber(multPhoneNumber);
						Log.d("AndroSync", "number is .. "+contactData.getContactNumber());
						
					}
					contactDataList.add(contactData);
					tempNumber = contactData.getContactNumber().toString();
					contactNameValuePair.add(new BasicNameValuePair(contactName,tempNumber));
					multipleContactCursor.close();
				}
				
				Toast.makeText(this, "Name:" + contactData.getContactName()+"  Number:"+contactData.getContactNumber(), Toast.LENGTH_SHORT).show();					
			
			} //temporary contactData objects gets destroyed here. 
		}
		
	}
	
}
