package org.kwahsog.auctionengine;

/** Value object representing a simple user of the auction system. 
 * 
 * @author Alex
 *
 */
public class User {
	
	private final int id;
	private final String name;
			
	/** Constructor for the user.
	 * 
	 * @param id User's id.
	 * @param name User's name.
	 */
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}	
	
}