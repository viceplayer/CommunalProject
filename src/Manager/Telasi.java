package Manager;


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
		String start = "class=\"list-group\">";
		String end = "</ul>";
		String result = "<ul";
		int started = 0;
		String[] tokens = content.split("[\\s]");
		for (String s : tokens) {
			if (s.equals(start)) {
				started = 1;
			}
			if (started == 1 && !s.equals("")) {
				result = result + " " + s;
			}
			if (started == 1 && s.equals(end))
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
	
	private static String getNameAndNumber() {
		String start = "class=\"page-header\">";
		String end = "</div>";
		String result = "<div";
		int started = 0;
		String[] tokens = content.split("[\\s]");
		for (String s : tokens) {
			if (s.equals(start)) {
				started = 1;
			}
			if (started == 1 && !s.equals("")) {
				result = result + " " + s;
			}
			if (started == 1 && s.equals(end))
				break;
		}
		return result;
		
	}


//	public static void main(String[] args) {
//		Telasi t = new Telasi(192819);
//		System.out.println(t.getTicketInfo());
//		System.out.println(t.getNameAndNumber());
//	}

}
