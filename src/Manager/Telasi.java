package Manager;



import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Telasi {

	private String url = "http://my.telasi.ge/customers/search?utf8=%E2%9C%93&accnumb=";
	private String endUrl = "&commit=ძებნა";
	private static String content = null;
	private static URLConnection connection = null;

	public Telasi(int TicketNum) {
		url = url + TicketNum + endUrl;
		getUrl(url);

	}
	
	
	public static String getTicketInfo() {
		String start = "class=\"list-group\">";
		String end = "</ul>";
		String result = "<ul";
		int started = 0;
		boolean  valid = true;
		String[] tokens = content.split("[\\s]");
		for (String s : tokens) {
			if (s.equals("<a")) valid = false;
			if (s.equals("</div>")) valid = true;
			if (s.equals(start)) {
				started = 1;
			}
			if (started == 1 && !s.equals("")) {
				if(valid) result = result + " " + s;
			}
			if (started == 1 && s.equals(end))
				break;
		}
		return result;

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
	
	public static String getNameAndNumber() {
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
				System.err.println(s);
			}
			if (started == 1 && s.equals(end))
				break;
		}
		return result;
		
	}



//	public static void main(String[] args) {
//		Telasi t = new Telasi(3691785);
//		System.out.println(t.getTicketInfo());
//		System.out.println(t.getNameAndNumber());
//	}

}
