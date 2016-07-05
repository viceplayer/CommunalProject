package Manager;

public class Transaction {

	private double amount;
	private String date;
	private String companyName;

	/**
	 * This is an constructor, which receives all the primary information, that 
	 * describes transaction of the user. It saves these information into it's instance variables.
	 * 
	 * @param cardNumber
	 * @param companyName
	 * @param amount
	 * @param date
	 */
	public Transaction(String companyName, double amount, String date) {
		this.amount = amount;
		this.date = date;
		this.companyName = companyName;
	}


	/**
	 * 
	 * @return amount to pay
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * 
	 * @return date of transaction
	 */
	public String getDate() {
		return date;
	}
 
	/**
	 * 
	 * @return name of the company
	 */
	public String getName() {
		return companyName;
	}
}
