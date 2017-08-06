package org.kwahsog.auctionenginetest;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kwahsog.auctionengine.Auction;
import org.kwahsog.auctionengine.Auctionable.BidResult;
import org.kwahsog.auctionengine.Bid;
import org.kwahsog.auctionengine.Item;
import org.kwahsog.auctionengine.User;

public class AuctionTest {

	private User TestUserOne, TestUserTwo, TestUserThree;
	private Item TestItemOne;
	private Auction firstAuction;
	
	@Before
	public void initialize() throws Exception {
		TestUserOne = new User(1, "Person One");
		TestUserTwo = new User(2, "Person Two");
		TestUserThree = new User(3, "Person Three");
		TestItemOne = new Item(1, "Item One", "Sample text...");
		firstAuction = new Auction(1, TestItemOne);
	}

	@Test
	public void testAuctionConstructor() {
		assertEquals(TestUserTwo.getId(),2);//todo: delete
		assertEquals(firstAuction.getId(), 1);
		assertEquals(firstAuction.getItem(), TestItemOne);
	}
	
	/*
	 * Testing requirement 1 "Record a user's bid on an item, each new bid must be at a higher price than before"
	 */
	@Test
	public void testSuccessfulAuctionBidding() {
		Bid firstBid = new Bid(TestUserOne, 10.00);
		Bid secondBid = new Bid(TestUserTwo, 20.00);
		Bid thirdBid = new Bid(TestUserThree, 30.00);
		assertEquals(firstAuction.makeBid(firstBid), BidResult.BID_SUCCESSFUL);
		assertEquals(firstAuction.makeBid(secondBid), BidResult.BID_SUCCESSFUL);
		assertEquals(firstAuction.makeBid(thirdBid), BidResult.BID_SUCCESSFUL);
	}

	/*
	 * Testing requirement 1 "Record a user's bid on an item, each new bid must be at a higher price than before"
	 */
	@Test
	public void testUnsuccessfulAuctionBidding() {
		Bid firstBid = new Bid(TestUserOne, 20.00);
		Bid secondBid = new Bid(TestUserTwo, 20.00);
		Bid thirdBid = new Bid(TestUserThree, 10.00);
		assertEquals(firstAuction.makeBid(firstBid), BidResult.BID_SUCCESSFUL);
		assertEquals(firstAuction.makeBid(secondBid), BidResult.BID_TOO_LOW);
		assertEquals(firstAuction.makeBid(thirdBid), BidResult.BID_TOO_LOW);
	}
	
	/*
	 *	Testing requirement 2 " Get the current winning bid for an item" 
	 */
	@Test
	public void testAuctionWinningBids() {
		Bid firstBid = new Bid(TestUserOne, 10.00);
		firstAuction.makeBid(firstBid);
		assertEquals(firstAuction.getWinningBid(), firstBid);
		Bid secondBid = new Bid(TestUserTwo, 20.00);
		firstAuction.makeBid(secondBid);
		assertEquals(firstAuction.getWinningBid(), secondBid);
		Bid thirdBid = new Bid(TestUserThree, 15.00);
		firstAuction.makeBid(thirdBid);
		assertEquals(firstAuction.getWinningBid(), secondBid);
	}
	
	/*
	 * Testing requirement 3 "Get all the bids for an item"
	 */
	@Test
	public void testAuctionGetAllBids() {
		Bid firstBid = new Bid(TestUserOne, 10.00);
		firstAuction.makeBid(firstBid);
		Bid secondBid = new Bid(TestUserTwo, 20.00);
		firstAuction.makeBid(secondBid);
		Bid thirdBid = new Bid(TestUserThree, 30.00);
		firstAuction.makeBid(thirdBid);
		LinkedList<Bid> allBids = new LinkedList<Bid>();
		allBids.add(firstBid);
		allBids.add(secondBid);
		allBids.add(thirdBid);
		assertEquals(firstAuction.getAllBids().size(), allBids.size());
		assertEquals(firstAuction.getAllBids().get(0), allBids.get(0));
		assertEquals(firstAuction.getAllBids().get(1), allBids.get(1));
		assertEquals(firstAuction.getAllBids().get(2), allBids.get(2));
	}
	
    @After
    public void tearDown() {
		TestUserOne = null;
		TestUserTwo = null;
		TestUserThree = null;
		TestItemOne = null;
		firstAuction = null;
    }   

}
