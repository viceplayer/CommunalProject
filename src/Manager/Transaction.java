package Manager;

public class Transaction {

	private int cardNumber;
	private int amount;
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
	public Transaction(int cardNumber, String companyName, int amount, String date) {
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.date = date;
		this.companyName = companyName;
	}

	/**
	 * @return 16 digit number of the card
	 */
	public int getCardNumber() {
		return cardNumber;
	}

	/**
	 * 
	 * @return amount to pay
	 */
	public int getAmount() {
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
