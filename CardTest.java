package elevens;

import junit.framework.TestCase;

public class CardTest extends TestCase {

//	public void testCard() {
//		fail("Not yet implemented");
//	}

	Card test = new Card("One", "Spades", 2);
	Card temp = new Card("Queen", "Spades", 2);
	Card temp_2 = new Card("King", "Hearts", 3);
	
	public void testGetSuit() {
		assertEquals(test.getSuit(), "Spades");
		assertEquals(temp.getSuit(), "Spades");
		assertEquals(temp_2.getSuit(), "Hearts");
	}

	public void testGetRank() {
		assertEquals(test.getRank(), "One");
		assertEquals(temp.getRank(), "Queen");
		assertNotSame(temp_2.getRank(), "Queen");
	}

	public void testGetPointValue() {
		assertEquals(test.getPointValue(), 2);
		assertEquals(temp.getPointValue(), 2);
		assertNotSame(temp_2.getPointValue(), 2);
	}

	public void testEqualsObject() {
		assertFalse(test.equals(temp));
	}

	public void testMatches() {
		assertFalse(test.matches(temp));
	}

	public void testToString() {
		assertEquals(test.toString(), "One of Spades (point value = 2)");
	}

}
