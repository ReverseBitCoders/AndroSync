package in.reversehack.androsync;

public class SmsDataAccumulator {
	private String smsContactNumber;
	private String smsBody;

	public void setSmsContactNumber(String number) {
		this.smsContactNumber = number;

	}

	public void setSmsBody(String body) {
		this.smsBody = body;

	}

	public String getSmsContactNumber() {
		return (this.smsContactNumber);
	}

	public String getSmsBody() {
		return (this.smsBody);

	}

};
