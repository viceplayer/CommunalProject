package Manager;


import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class CompanyInfo {

	private String url = "http://my.telasi.ge/customers/search?utf8=%E2%9C%93&accnumb=";
	private String endUrl = "&commit=ძებნა";
	private static String content = null;
	private static URLConnection connection = null;
	private String GWPTaxes = "";
	private String TrashTaxes = "";
	private String TelasiTaxes = "";
	private String name = "";
	private String deadLine = "";

	/**
	 * This constructor connects to the url and calls method which makes
	 * filtering of the url
	 * 
	 * @param TicketNum
	 */
	public CompanyInfo(int ticketNum) {
		url = url + ticketNum + endUrl;
		getUrl(url);
		getTicketInfo();
		findName();

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
	 * This method filters page of the telasi in a specific way. It gets all the
	 * information from it and saves into instance variables.
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
					GWPTaxes = s.substring(s.indexOf('>') + 1, s.indexOf('/') - 1);
					started++;
				}
				if (started == 2 && !s.equals("") && s.startsWith(indicator)) {
					TrashTaxes = s.substring(s.indexOf('>') + 1, s.indexOf('/') - 1);
					started++;
				}
				if (started == 1 && !s.equals("") && s.startsWith(indicator)) {
					TelasiTaxes = s.substring(s.indexOf('>') + 1, s.indexOf('/') - 1);
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
	public ArrayList<String> getTrashTaxes() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("დასუფთავების  გადასახადი: ");
		l.add(TrashTaxes);
		l.add(deadLine);
		l.add(name);
		return l;
	}



	/**
	 * 
	 * @return fee of electricity
	 */
	public ArrayList<String> getTelasiTaxes() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("თელასის გადასახადი: ");
		l.add(TelasiTaxes);
		l.add(deadLine);
		l.add(name);
		return l;
	}

	/**
	 * 
	 * @return fee of water
	 */
	public ArrayList<String> getGWPTaxes() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("წალმომარაგების გადასახადი: ");
		l.add(GWPTaxes);
		l.add(deadLine);
		l.add(name);
		return l;
	}

	/**
	 * Connects to the url and scans whole source
	 * 
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
	 * Checks, whether each letter of the name is in georgian alphabet
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
}
