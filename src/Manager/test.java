package Manager;



public class test {
	public static void main(String[] args) {
		Telasi t = new Telasi(1129335);
		System.out.println(t.getDeadLine());
		System.out.println(t.getElectricTaxes());
		System.out.println(t.getName());
		System.out.println(t.getTrashTaxes());
		System.out.println(t.getWaterTaxes());
		t = new Telasi(3691785);
		System.out.println(t.getDeadLine());
		System.out.println(t.getElectricTaxes());
		System.out.println(t.getName());
		System.out.println(t.getTrashTaxes());
		System.out.println(t.getWaterTaxes());
	}
}
