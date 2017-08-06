package org.kwahsog.auctionengine;

/** Bid class to represent an auction bid made by a given user for a given price.
 * 
 * @author Alex
 *
 */
public class Bid {

	private final User user;
	private final double price;
	
	/** Constructor for the bid.
	 * 
	 * @param user The user making the bid.
	 * @param price The price of the bid.
	 */
	public Bid(User user, double price) {
		super();
		this.user = user;
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Bid [user=" + user + ", price=" + price + "]";
	}	
}
