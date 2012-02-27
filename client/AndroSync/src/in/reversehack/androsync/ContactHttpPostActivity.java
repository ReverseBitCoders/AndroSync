package in.reversehack.androsync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BufferedHeader;

import android.app.Activity;
import android.os.Bundle;

public class ContactHttpPostActivity extends SyncContactsActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BufferedReader inBufferedReader = null;
		try {
			HttpClient contactHttpClient = new DefaultHttpClient();
			HttpPost contactRequester = new HttpPost("some URL");
			UrlEncodedFormEntity basicContactFormEntity = new UrlEncodedFormEntity(
					contactNameValuePair);
			contactRequester.setEntity(basicContactFormEntity);
			HttpResponse httpResponse = contactHttpClient
					.execute(contactRequester);

			inBufferedReader = new BufferedReader(new InputStreamReader(
					httpResponse.getEntity().getContent()));
			StringBuffer stringBuff = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");

			while ((line = inBufferedReader.readLine()) != null) {
				stringBuff.append(line + NL);
			}
			inBufferedReader.close();
			String serverReturnedThis = stringBuff.toString();
			System.out.println(serverReturnedThis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inBufferedReader != null) {
				try {
					inBufferedReader.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
