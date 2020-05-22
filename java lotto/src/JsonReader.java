import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
//	public JSONObject connectionUrlToJSON(String turn) throws Exception{
	public JSONObject connectionUrlToJSON(String turn) throws Exception{
		URL url= new URL("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + turn);
		HttpsURLConnection conn = null;
		HostnameVerifier hnv = new HostnameVerifier() {
			
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hnv);
		
		conn = (HttpsURLConnection) url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String iLine = br.readLine();
		JSONParser ps = new JSONParser();
		JSONObject jObj = (JSONObject)ps.parse(iLine);
		return jObj;
			
	}

}
