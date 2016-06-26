package Manager;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Telasi {

	private String url = "http://my.telasi.ge/customers/search?utf8=%E2%9C%93&accnumb=";
	private String endUrl = "&commit=ძებნა";
	private static String content = null;
	private static URLConnection connection = null;
	private static String water;
	private static String trash;
	private static String electric;

	public Telasi(int TicketNum) {
		url = url + TicketNum + endUrl;
		getUrl(url);
		getTicketInfo();

	}

	private static void getTicketInfo() {
		String start = "class=\"list-group\">";
		String end = "</ul>";
		String indicator = "<code>";
		int started = 0;
		String[] tokens = content.split("[\\s]");
		for (String s : tokens) {
			if (s.equals(start)) {
				started = 1;
			}
			if (started == 3 && s.startsWith(indicator)) {
				water = s.substring(s.indexOf('>') + 1, s.indexOf('/') - 1);
				started++;
			}
			if (started == 2 && s.startsWith(indicator)) {
				trash = s.substring(s.indexOf('>') + 1, s.indexOf('/') - 1);
				started++;
			}
			if (started == 1 && s.startsWith(indicator)) {
				electric = s.substring(s.indexOf('>') + 1, s.indexOf('/') - 1);
				started++;
			}
			if (started >= 1 && s.equals(end))
				break;
		}

	}
	
	public String trashTaxes(){
		return trash;
	}
	
	public String electricTaxes(){
		return electric;
	}
	
	public String waterTaxes(){
		return water;
	}

	private static void getUrl(String url) {
		try {
			connection = new URL(url).openConnection();
			Scanner scanner = new Scanner(connection.getInputStream(), "UTF-8");
			scanner.useDelimiter("\\Z");
			content = scanner.next();
			scanner.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getName() {
		String start = "class=\"page-header\">";
		String end = "</div>";
		String result = "";
		int started = 0;
		String[] tokens = content.split("[\\s]");
		for (String s : tokens) {
			if (s.equals(start)) {
				started = 1;
			}
			if (started >= 1 && !s.equals("")) {
				if (started == 3)
					result = result + " " + s;
				started++;
			}
			if (started >= 1 && s.equals(end))
				break;
		}
		return result;

	}



}
