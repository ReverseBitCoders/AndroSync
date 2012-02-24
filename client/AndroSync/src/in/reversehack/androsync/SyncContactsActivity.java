package in.reversehack.androsync;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

public class SyncContactsActivity extends Activity {

	ContactInfoAccumulator contactData = new ContactInfoAccumulator();
	public ArrayList<ContactInfoAccumulator> contactDataList = new ArrayList<ContactInfoAccumulator>(2);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sync_contacts);
		getContactNumbers();
	}

	public void getContactNumbers() {

		ContentResolver contactContentResolver = getContentResolver();
		Cursor contactCursor = contactContentResolver.query(
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		if (contactCursor.getCount() > 0) {
			while (contactCursor.moveToNext()) {
				String contactId = contactCursor.getString(contactCursor
						.getColumnIndex(ContactsContract.Contacts._ID));
				String contactName = contactCursor
						.getString(contactCursor
								.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				
			contactData.setContactName(contactName);
				

				if (Integer
						.parseInt(contactCursor.getString(contactCursor
								.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {

					Cursor multipleContactCursor = contactContentResolver
							.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
									null,
									ContactsContract.CommonDataKinds.Phone.CONTACT_ID
											+ "=?", new String[] { contactId },
									null);

					while (multipleContactCursor.moveToNext()) {
						String multPhoneNumber = multipleContactCursor
								.getString(multipleContactCursor
										.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
						
						contactData.setContactNumber(multPhoneNumber);

					}
					multipleContactCursor.close();
				}
			}
		}

	}
}
