package org.kwahsog.auctionengine;

import java.util.ArrayList;

/**
 * Interface for a collection of auctions.
 * @author Alex
 *
 */
public interface AuctionStorable {
	
	/**
	 * Creates new auction and stores it internally.
	 * @param auction
	 */
	public void createAuction(Auction auction);
	
	/**
	 * Removes a given auction from the storage.
	 * @param id
	 */
	public void deleteAuction(int id);
	
	/** 
	 * Returns the auction for a given id
	 * @param id Auction id
	 * @return the auction.
	 */
	public Auction getAuction(int id);
	
	/**
	 * For a given user, returns all items bid on by that user by searching the internal storage.
	 * @param user The user.
	 * @return ArrayList of items bid on;
	 */
	public ArrayList<Item> getUsersBiddedItems(User user);

}
