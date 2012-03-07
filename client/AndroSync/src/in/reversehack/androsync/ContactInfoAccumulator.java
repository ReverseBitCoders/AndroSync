package in.reversehack.androsync;

import java.util.AbstractList;
import java.util.ArrayList;

public class ContactInfoAccumulator extends AbstractList<String> {

	public ArrayList<String> contactNumbers = new ArrayList<String>(1);
	public String contactName;
	public String contact_ID;

	public String getContactName() {
		return (this.contactName);
	}

	public void setContactID(String ID) {
		this.contact_ID = ID;

	}

	public String getContactID() {
		return (this.contact_ID);
	}

	public ArrayList<String> getContactNumber() {
		return (this.contactNumbers);
	}

	public void setContactName(String name) {
		this.contactName = name;
	}

	public void setContactNumber(String number) {
		this.contactNumbers.add(number);
	}

	/*
	 * The following Methods are not really used. Just for sake of
	 * implementing/overriding the interface methods.
	 */
	@Override
	public String get(int location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

};
