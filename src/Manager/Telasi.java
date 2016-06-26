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
	private static String name = "";
	private static String deadLine = "";

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
		int time = 0;
		boolean invalid = true;
		String[] tokens = content.split("[\\s]");
		for (String s : tokens) {
			if (s.equals(start)) {
				started = 1;
			}
			if (!invalid) {
				if (started == 3 && !s.equals("") && s.startsWith(indicator)) {
					water = s.substring(s.indexOf('>') + 1, s.indexOf('/') - 1);
					started++;
				}
				if (started == 2 && !s.equals("") && s.startsWith(indicator)) {
					trash = s.substring(s.indexOf('>') + 1, s.indexOf('/') - 1);
					started++;
				}
				if (started == 1 && !s.equals("") && s.startsWith(indicator)) {
					electric = s.substring(s.indexOf('>') + 1, s.indexOf('/') - 1);
					started++;
				}
				if (started >= 1 && !s.equals("") && time == 1) {
					deadLine = s;
					time = 0;
				}
			}
			if (started >= 1 && s.startsWith("fa-time")) {
				time = 1;
			}
			if (started >= 1 && s.startsWith("გადახდა")) {
				invalid = true;
			}
			if (started >= 1 && !s.startsWith("გადახდა")) {
				invalid = false;
			}
			if (started >= 1 && s.equals(end))
				break;
		}
	}

	public String getTrashTaxes() {
		return trash;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public String getElectricTaxes() {
		return electric;
	}

	public String getWaterTaxes() {
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

	public String getName() {
		String start = "class=\"page-header\">";
		String end = "</div>";
		int started = 0;
		String[] tokens = content.split("[\\s]");
		for (String s : tokens) {
			if (s.equals(start)) {
				started = 1;
			}
			if (started >= 1 && !s.equals("")) {
				if (started == 3)
					name = name + " " + s;
				started++;
			}
			if (started >= 1 && s.equals(end))
				break;
		}
		chackName();
		return name;
	}

	private static void chackName() {
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) < 'ა' || name.charAt(i) > 'ჰ') {
				String replace = "" + name.charAt(i);
				name = name.replaceAll(replace, "");
				i--;
			}
		}
	}
	
}
