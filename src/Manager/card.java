package Manager;

public class card {
	private int userId;
	private String cardNumber;
	private String date;
	private String firstName;
	private String lastName;
	
	public card(int userId, String cardNumber, String date, String firstName, String lastName){
		this.cardNumber = cardNumber;
		this.userId = userId;
		this.date = date;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getCardNumber(){
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
