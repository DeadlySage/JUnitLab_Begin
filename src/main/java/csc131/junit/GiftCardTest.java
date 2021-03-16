package csc131.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest {

	@Test
	public void testGetIssuingStore() 
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
		assertEquals("getBalance()", balance, card.getBalance(), 0.0001);
		
	}
	
	@Test
	public void testGetBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.0001);
	}
	
	@Test
	public void deduct_RemainingBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String x;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		x = "Remaining Balance: " + String.format("%6.2f", balance - 20.0);
		
		assertEquals("deduct() 20 from 100.00", x, card.deduct(20.0));
	}
	
	@Test
	public void deduct_InvalidTransaction()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String x;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		x = "Invalid Transaction";
		
		assertEquals("deduct() - 20.0 from 100.00", x, card.deduct(-20.0));
	}
	
	@Test
	public void deduct_AmountDue()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String x;
		
		issuingStore = 1337;
		balance = 0.00;
		card = new GiftCard(issuingStore, balance);
		
		x = "Amount Due: " + String.format("%6.2f", 20.0);
		
		assertEquals("deduct() 20 from 0.00", x, card.deduct(20.0));
	}
	
	@Test
	public void constructor_IlligalBalance() 
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_Low()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_High()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100.00);});
	}
}
