package Manager;

public class object {

	private int id;
	private int userId;
	private int type;
	private String name;

	public object(int id, int userId, int type, String name) {
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}
