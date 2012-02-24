package in.reversehack.androsync;

import java.util.AbstractList;
import java.util.ArrayList;

public class ContactInfoAccumulator extends AbstractList<String>{
	private ArrayList<String> contactNumbers = new ArrayList<String>(1);
	private String contactName;
	//private String contactEmail;
	
	public String getContactName() {
		return(this.contactName);
	}
	
/*	public String getContactEmail(){
		return(this.contactEmail);
		
	}*/  
	
	public ArrayList<String> getContactNumber() {
		return(this.contactNumbers);
	}
	
	public void setContactName(String name) {
		this.contactName = name;
	}
	
	/*public void setContactEmail(String email) {
		this.contactEmail = email;
	} */
	
	public void setContactNumber(String number) {
		this.contactNumbers.add(number);
	}

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
