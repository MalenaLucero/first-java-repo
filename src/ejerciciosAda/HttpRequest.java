package ejerciciosAda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://random-word-api.herokuapp.com/word?number=1");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int status = con.getResponseCode();
		//status 200 quiere decir que salio todo bien
		System.out.println(status);
		BufferedReader in = new BufferedReader(
		new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		    content.append(inputLine);
		}
		//content es la respuesta de la api como String
		System.out.println(content);
		in.close();
	}
}
