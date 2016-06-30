package Manager;

public class Card {
	private int userId;
	private String cardNumber;
	private String date;
	private String firstName;
	private String lastName;
	
	/**
	 * This is an constructor, which receives all the primary information, that 
	 * describes card of the user. It saves these information into it's instance variables.
	 * @param userId
	 * @param cardNumber
	 * @param date
	 * @param firstName
	 * @param lastName
	 */
	public Card(int userId, String cardNumber, String date, String firstName, String lastName){
		this.cardNumber = cardNumber;
		this.userId = userId;
		this.date = date;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/**
	 * 
	 * @return cardNumber instance variable
	 */
	public String getCardNumber(){
		return cardNumber;
	}
	/**
	 * 
	 * @return userId instance variable
	 */
	public int getUserId(){
		return userId;
	}
	/**
	 * 
	 * @return date instance variable
	 */
	public String getDate(){
		return date;
	}
	/**
	 * 
	 * @return firstName instance variable
	 */
	public String getFirstName(){
		return firstName;
	}
	/**
	 * 
	 * @return lastName instance variable
	 */
	public String getLastName(){
		return lastName;
	}
	
}
