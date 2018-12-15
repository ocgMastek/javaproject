package IoExample;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Cart implements Serializable {

	private List<Item> items;
	
	private int empno;
	
	public Cart() {
		items = new LinkedList<>();
	}
	
	public void addItem(Item itemone) {
		this.items.add(itemone);
	}
	
}
