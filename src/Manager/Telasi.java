package Manager;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class Telasi {

	private String url = "http://my.telasi.ge/customers/search?utf8=%E2%9C%93&accnumb=";
	private String endUrl = "&commit=ძებნა";
	private static String content = null;
	private static URLConnection connection = null;
	private String water= "";
	private String trash= "";
	private String electric= "";
	private String name = "";
	private String deadLine = "";
	/**
	 * This constructor connects to the url and calls method
	 * which makes filtering of the url
	 * @param TicketNum
	 */
	public Telasi(int ticketNum) {
		System.out.println("x" + ticketNum + "x");
		url = url + ticketNum + endUrl;
		getUrl(url);
		getTicketInfo();
		findName();
		System.out.println(getName());
		System.out.println("-"+ getElectricTaxes() +"-"+ getWaterTaxes() +"-"+  getTrashTaxes() +"-"+ getDeadLine());
	}

	private void findName() {
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
		
	}

	/**
	 * This method filters page of the telasi in a specific way.
	 * It gets all the information from it and saves into instance variables.
	 */
	private void getTicketInfo() {
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
	/**
	 * 
	 * @return fee of the trash
	 */
	public String getTrashTaxes() {
		return trash;
	}
	/**
	 * 
	 * @return last date, until user must pay
	 */
	public String getDeadLine() {
		return deadLine;
	}

	/**
	 * 
	 * @return fee of electricity
	 */
	public String getElectricTaxes() {
		return electric;
	}
	/**
	 * 
	 * @return fee of water
	 */
	public String getWaterTaxes() {
		return water;
	}
	/**
	 * Connects to the url and scans whole source
	 * @param url
	 */
	private void getUrl(String url) {
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

	/**
	 * Filters the source and gets name of the user from the url
	 * @return name of the user
	 */
	public String getName() {
		return name;
	}

	/**
	 * Checks, whether each letter of the  name is in georgian alphabet
	 */
	private void chackName() {
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) < 'ა' || name.charAt(i) > 'ჰ') {
				String replace = "" + name.charAt(i);
				name = name.replaceAll(replace, "");
				i--;
			}
		}
	}
	
	public static void main(String[] args) {
		Telasi t = new Telasi(1129335);
		System.out.println(t.getDeadLine());
		System.out.println(t.getElectricTaxes());
		System.out.println(t.getName());
		System.out.println(t.getTrashTaxes());
		System.out.println(t.getWaterTaxes());
		t = new Telasi(3691785);
		System.out.println(t.getDeadLine());
		System.out.println(t.getElectricTaxes());
		System.out.println(t.getName());
		System.out.println(t.getTrashTaxes());
		System.out.println(t.getWaterTaxes());
	}
}
