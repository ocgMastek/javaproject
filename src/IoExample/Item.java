package IoExample;

public class Item {
	private String name;
	private int quantity;
	private int unitprice;
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getUnitPrice() {
		return unitprice;
	}
	
	@Override
	public String toString() {
		return name + " " + quantity + " "  + " " + unitprice;
	}
}
