package Manager;

public class Ticket {
	private int objectId;
	private String companyName;
	private String ticket;
	private int companyId;

	public Ticket(int objectId, String companyName, String ticket, int companyId) {
		this.objectId = objectId;
		this.companyName = companyName;
		this.ticket = ticket;
		this.companyId = companyId;
	}

	public int getObjectId() {
		return objectId;
	}
	
	public int getCompanyId() {
		return companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getTicket() {
		return ticket;
	}

}
