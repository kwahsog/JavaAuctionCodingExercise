package org.kwahsog.auctionengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the AuctionStorable interface. 
 * Provide storage of a collection of auctions.
 * @author Alex
 *
 */
public class AuctionHouse implements AuctionStorable {

	//private Map<User,ArrayList<Item>> userBiddedOnItems = new HashMap<User,ArrayList<Item>>();
	//private ArrayList<Auction> auctions;
	private Map<Integer, Auction> auctions = new HashMap<Integer,Auction>();
	
	public void createAuction(Auction auction) {
		auctions.put(auction.getId(), auction);
	}

	public void deleteAuction(int id) {
		auctions.remove(id);
	}

	public Auction getAuction(int id) {
		return auctions.get(id);
	}

	/*
	 * Iterate through all stored auctions and record unique items to return list of bidded on items for a given user.
	 */
	public ArrayList<Item> getUsersBiddedItems(User user) {
		ArrayList<Item> items = new ArrayList<Item>();
		Iterator<Map.Entry<Integer, Auction>> it = auctions.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Auction> pair = it.next();
			Auction tempAuctions = pair.getValue();
			//LinkedList<Bid> tempBids = tempAuctions.getAllBids();
			for (Bid bid: tempAuctions.getAllBids()) {
				if (bid.getUser().getId() == user.getId()) {
					items.add(tempAuctions.getItem());
					break;
				}
			}
		}
		return items;
	}

}
