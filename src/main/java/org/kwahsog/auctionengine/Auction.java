package org.kwahsog.auctionengine;

import java.util.LinkedList;

/**
 * Implementation of the AuctionableItem interface. 
 * Provides constuctor for an Auction on a given item, allowing bids to be made and bid information to be retrieved.
 * @author Alex
 *
 */
public class Auction implements Auctionable {
	
	private LinkedList<Bid> bids;	
	private final int id;
	private final Item item;
	
	/**
	 * Creates an auction for a given item;
	 * @param id
	 * @param item
	 */
	public Auction(int id, Item item) {
		super();
		this.id = id;
		this.item = item;
		this.bids = new LinkedList<Bid>();
	}
	
	public int getId() {
		return id;
	}

	public Item getItem() {
		return item;
	}
	
	public BidResult makeBid(Bid myBid) {
		if (bids.size() > 0) {
			if (bids.getLast().getPrice() < myBid.getPrice()) {
				bids.add(myBid);
				return BidResult.BID_SUCCESSFUL;
			} else {
				return BidResult.BID_TOO_LOW;
			}
		} else {
			bids.add(myBid);
			return BidResult.BID_SUCCESSFUL;
		}
	}

	public Bid getWinningBid() {
		if (bids.size() > 0) {
			return bids.getLast();
		} else {
			return null;
		}
	}

	public LinkedList<Bid> getAllBids() {
		return bids;
	}

}
