package org.kwahsog.auctionenginetest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kwahsog.auctionengine.Auction;
import org.kwahsog.auctionengine.AuctionHouse;
import org.kwahsog.auctionengine.Bid;
import org.kwahsog.auctionengine.Item;
import org.kwahsog.auctionengine.User;

public class AuctionHouseTest {

	private User TestUserOne, TestUserTwo, TestUserThree;
	private Item TestItemOne, TestItemTwo;
	private Auction firstAuction, secondAuction;
	private AuctionHouse auctionHouse;
	
	@Before
	public void initialize() throws Exception {
		TestUserOne = new User(1, "Person One");
		TestUserTwo = new User(2, "Person Two");
		TestUserThree = new User(3, "Person Three");
		TestItemOne = new Item(1, "Item One", "Sample text...");
		TestItemTwo = new Item(2, "Item Two", "Sample text...");
		firstAuction = new Auction(1, TestItemOne);
		secondAuction = new Auction(2, TestItemTwo);
		auctionHouse = new AuctionHouse();
	}

	@Test
	public void testAuctionHouseConstructor() {
		auctionHouse.createAuction(firstAuction);
		auctionHouse.createAuction(secondAuction);
		assertEquals(auctionHouse.getAuction(1),firstAuction);
		assertEquals(auctionHouse.getAuction(2),secondAuction);
		assertNotNull(auctionHouse.getAuction(2));
		auctionHouse.deleteAuction(2);
		assertNull(auctionHouse.getAuction(2));
	}
	
	@Test
	public void testAuctionHouseImbeddedAuctions() {
		auctionHouse.createAuction(firstAuction);
		Auction testAuction = auctionHouse.getAuction(1);
		Bid firstBid = new Bid(TestUserOne, 10.00);
		Bid secondBid = new Bid(TestUserTwo, 20.00);
		testAuction.makeBid(firstBid);
		testAuction.makeBid(secondBid);
		
		assertEquals(auctionHouse.getAuction(1).getAllBids().get(0), firstBid);
		assertEquals(auctionHouse.getAuction(1).getAllBids().get(1), secondBid);
		assertEquals(auctionHouse.getAuction(1).getWinningBid(), secondBid);
		
		auctionHouse.createAuction(secondAuction);
		Auction secondTestAuction = auctionHouse.getAuction(2);
		Bid thirdBid = new Bid(TestUserOne, 50.00);
		Bid fourthBid = new Bid(TestUserTwo, 80.00);
		secondTestAuction.makeBid(thirdBid);
		secondTestAuction.makeBid(fourthBid);
		
		assertEquals(auctionHouse.getAuction(2).getAllBids().get(0), thirdBid);
		assertEquals(auctionHouse.getAuction(2).getAllBids().get(1), fourthBid);
		assertEquals(auctionHouse.getAuction(2).getWinningBid(), fourthBid);
	}
	
	/*
	 * Testing requirement 4 "Get all the items on which a user has bid"
	 */
	@Test
	public void testAuctionHousegetUsersBiddedItems() {
		
		auctionHouse.createAuction(firstAuction);
		Auction testAuction = auctionHouse.getAuction(1);
		Bid firstBid = new Bid(TestUserOne, 10.00);
		Bid secondBid = new Bid(TestUserTwo, 20.00);
		testAuction.makeBid(firstBid);
		testAuction.makeBid(secondBid);
		
		auctionHouse.createAuction(secondAuction);
		Auction secondTestAuction = auctionHouse.getAuction(2);
		Bid thirdBid = new Bid(TestUserOne, 50.00);
		Bid fourthBid = new Bid(TestUserTwo, 80.00);
		Bid fifthBid = new Bid(TestUserThree, 2221.00);
		secondTestAuction.makeBid(thirdBid);
		secondTestAuction.makeBid(fourthBid);
		secondTestAuction.makeBid(fifthBid);
		
		ArrayList<Item> expectedItemsUserOne = new ArrayList<Item>();
		expectedItemsUserOne.add(TestItemOne);
		expectedItemsUserOne.add(TestItemTwo);
		ArrayList<Item> expectedItemsUserThree = new ArrayList<Item>();
		expectedItemsUserThree.add(TestItemTwo);
		
		assertEquals(auctionHouse.getUsersBiddedItems(TestUserOne),expectedItemsUserOne);
		assertEquals(auctionHouse.getUsersBiddedItems(TestUserThree),expectedItemsUserThree);
	}
	
    @After
    public void tearDown() {
		TestUserOne = null;
		TestUserTwo = null;
		TestUserThree = null;
		TestItemOne = null;
		TestItemTwo = null;
		firstAuction = null;
		auctionHouse = null;
    }   

}
