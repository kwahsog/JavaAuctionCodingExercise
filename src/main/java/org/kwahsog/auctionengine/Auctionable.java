package org.kwahsog.auctionengine;

import java.util.LinkedList;

/**
 * Interface for auctionable items.
 * @author Alex
 *
 */
public interface Auctionable {
	
	public enum BidResult { BID_SUCCESSFUL, AUCTION_ENDED, BID_TOO_LOW};
	
	/** 
	 * Records a user's bid on an item as part of an auction, evaluating success of the bid.
	 * 
	 * @param myBid Instance of the bid.
	 * @return BidResult enum based on success of bid.
	 */
	public BidResult makeBid(Bid myBid); 
	
	/** 
	 * Returns the current winning bid for an item in an auction.
	 * 
	 * @return Bid the winning bid.
	 */
	public Bid getWinningBid();
	
	/**
	 * Returns all bids for a specific item in an auction.
	 * 
	 * @return all bids.
	 */
	public LinkedList<Bid> getAllBids();
}
