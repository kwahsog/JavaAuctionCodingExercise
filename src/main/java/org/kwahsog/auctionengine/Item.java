package org.kwahsog.auctionengine;

/** Value object representing a simple item in the auction system. 
 * 
 * @author Alex
 *
 */
public class Item {

	private final int id;
	private final String name;
	private final String additonalInfo;

	/** Constructor for the item.
	 * 
	 * @param id Item id;
	 * @param name Item name;
	 * @param additonalInfo Additional information for the item.
	 */
	public Item(int id, String name, String additonalInfo) {
		super();
		this.id = id;
		this.name = name;
		this.additonalInfo = additonalInfo;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAdditonalInfo() {
		return additonalInfo;
	}
	
	@Override
	public String toString() {
		return "AuctionItem [id=" + id + ", itemName=" + name + ", additonalInfo=" + additonalInfo + "]";
	}

}
