package Manager;

public class Transaction {


	private int cardNumber;
	private int amount;
	private java.sql.Date date;
	private String companyName;
	
	public Transaction(int cardNumber,String companyName, int amount,java.sql.Date date){
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.date = date;
		this.companyName = companyName;
	}
	
	public int getCardNumber(){
		return cardNumber;
	}
	public int getAmount(){
		return amount;
	}
	public java.sql.Date getDate(){
		return date;
	}
	public String getName(){
		return companyName;
	}
}
