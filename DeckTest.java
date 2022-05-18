package elevens;

import junit.framework.TestCase;

public class DeckTest extends TestCase {
    String[] ranks_1 = new String[] {"Jack", "Queen", "King"};
    String[] ranks_2 = new String[] {"One", "Jack"};
    String[] ranks_3 = new String[] {"Jack", "Queen", "King"};
    String[] suits_1 = new String[] {"blue", "blue", "red"};
    String[] suits_2 = new String[] {"red", "red"};
    String[] suits_3 = new String[] {"blue", "red", "red"};
    int[] values_1 = new int[] {11, 12, 13};
    int[] values_2 = new int[] {1, 11};
    int[] values_3 = new int[] {11, 12, 13};
    Deck d1 = new Deck(ranks_1, suits_1, values_1);
    Deck d2 = new Deck(ranks_2, suits_2, values_2);
    Deck d3 = new Deck(ranks_3, suits_3, values_3);

    public void testIsEmpty() {
        assertFalse(d1.isEmpty());
        d2.deal();
        d2.deal();
        assertTrue(d2.isEmpty());
        assertFalse(d3.isEmpty());
    }

    public void testSize() {
        assertEquals(d1.size(), 3);
        d2.deal();
        d2.deal();
        assertEquals(d2.size(), 0);
        assertEquals(d3.size(), 3);
    }

    public void testShuffle() {
        Deck d4 = new Deck(ranks_3, suits_3, values_3);
        d3.shuffle();
        assertNotSame(d3.toString(), d4.toString());
    }

    public void testDeal() {
        Card tempCard = new Card("Queen", "blue", 12);
        System.out.println(d1.deal().toString());
        System.out.println(tempCard.toString());
        assertEquals(d1.deal().toString(), tempCard.toString());
        assertEquals(d1.size(), 1);
    }
}