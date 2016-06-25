package Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Telasi {

	private String url = "http://my.telasi.ge/customers/info/";
	private static String content = null;
	private static URLConnection connection = null;

	public Telasi(int TicketNum) {
		url = url + TicketNum;
		getUrl(url);

	}

	private static String getTicketInfo() {
		String result = "<ul ";
		int start = 0;
		String[] tokens = content.split("[\\s]");
		for (String s : tokens) {
			if (s.equals("class=\"list-group\">")) {
				start = 1;
			}
			if (start == 1 && !s.equals("")) {
				result = result + " " + s;
			}
			if (start == 1 && s.equals("</ul>"))
				break;
		}
		return result;

	}

	private static void getUrl(String url) {
		try {
			connection = new URL(url).openConnection();
			Scanner scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter("\\Z");
			content = scanner.next();
			scanner.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static String getUrlSource(String url) throws IOException {

		URL web = new URL(url);
		URLConnection wc = web.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(wc.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuilder a = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			a.append(inputLine);
		in.close();

		return a.toString();
	}

	public static void main(String[] args) {
		Telasi t = new Telasi(192819);
		System.out.println(t.getTicketInfo());
	}

}
