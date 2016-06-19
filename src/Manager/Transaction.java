package Manager;

public class Transaction {


	private int cardNumber;
	private int amount;
	private String date;
	private String companyName;
	
	public Transaction(int cardNumber,String companyName, int amount,String date){
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
	public String getDate(){
		return date;
	}
	public String getName(){
		return companyName;
	}
}
