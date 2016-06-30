package Manager;

public class object {

	private int id;
	private int userId;
	private int type;
	private String name;

	/**
	 * This is an constructor, which receives all the primary information, that
	 * describes object of the user. It saves these information into it's
	 * instance variables.
	 * 
	 */
	public object(int id, int userId, int type, String name) {
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.name = name;
	}

	/**
	 * returns personalId of the user
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return id of the user
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * returns type of the object
	 */
	public int getType() {
		return type;
	}

	/**
	 * 
	 * @return name of the object
	 */
	public String getName() {
		return name;
	}
}
