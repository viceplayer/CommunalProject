package Manager;

public class card {
	private int userId;
	private int cardNumber;
	private String date;
	private String firstName;
	private String lastName;
	
	public card(int userId, int cardNumber, String date, String firstName, String lastName){
		this.cardNumber = cardNumber;
		this.userId = userId;
		this.date = date;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getCardNumber(){
		return cardNumber;
	}
	public int getUserId(){
		return userId;
	}
	public String getDate(){
		return date;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	
}
