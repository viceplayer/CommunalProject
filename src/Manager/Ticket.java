package Manager;

public class Ticket {
	private int objectId;
	private String companyName;
	private String ticket;

	public Ticket(int objectId, String companyName, String ticket) {
		this.objectId = objectId;
		this.companyName = companyName;
		this.ticket = ticket;
	}

	public int getObjectId() {
		return objectId;
	}

	//Returns Company name
	public String getCompanyName() {
		return companyName;
		
	}

	public String getTicket() {
		return ticket;
	}

}
