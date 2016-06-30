package Manager;

public class Ticket {
	private int objectId;
	private String companyName;
	private String ticket;
	private int companyId;

	/**
	 * This is an constructor, which receives all the primary information, that 
	 * describes ticket of the user. It saves these information into it's instance variables.
	 * @param objectId
	 * @param companyName
	 * @param ticket
	 * @param companyId
	 */
	public Ticket(int objectId, String companyName, String ticket, int companyId) {
		this.objectId = objectId;
		this.companyName = companyName;
		this.ticket = ticket;
		this.companyId = companyId;
	}

	/**
	 * 
	 * @return id of the object, in which ticket is.
	 */
	public int getObjectId() {
		return objectId;
	}
	
	/**
	 * 
	 * @return id of the company
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * 
	 * @return name of the company
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 
	 * @return ticket number
	 */
	public String getTicket() {
		return ticket;
	}

}
