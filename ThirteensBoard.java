package elevens;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.RandomAccess;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ThirteensBoard extends Board{
    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 10;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
//commented out by Simon
    public ThirteensBoard() {
        super(ThirteensBoard.BOARD_SIZE, ThirteensBoard.RANKS, ThirteensBoard.SUITS, ThirteensBoard.POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    public boolean isLegal(List<Integer> selectedCards) {
        if(selectedCards.size() == 1) {
            return findK(selectedCards).size() != 0;
        }
        else
            return findPairSum13(selectedCards).size() != 0;
    }


    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    public boolean anotherPlayIsPossible() {
        List<Integer> selected = cardIndexes();
        for (int i = 0; i < selected.size(); i++) {
            List<Integer> test = new ArrayList<Integer>();
            int c1 = selected.get(i);
            test.add(c1);
            if(isLegal(test) == true) {
                System.out.println("That's a King!");
                return true;
            }
            for (int j = i; j < selected.size(); j++) {
                int c2 = selected.get(j);
                test.add(c2);
                System.out.println(test.toString());
                if (isLegal(test) == true) {
                    System.out.println("contains 13");
                    return true;
                }
                test.remove(test.indexOf(c2));
            }
        }
        return false;
    }



    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
//commented out by Simon
    private List<Integer> findPairSum13(List<Integer> selectedCards) {
        List<Integer> values = new ArrayList<Integer>();
        List<Integer> out = new ArrayList<Integer>();
        for(int i = 0; i < selectedCards.size(); i++)
            values.add(cardAt(selectedCards.get(i)).getPointValue());
        for(int i = 0; i < selectedCards.size(); i++) {
            int temp = values.get(i);
            if(values.contains(13 - temp)) {
                out.add(values.indexOf(temp));  out.add(values.indexOf(13 - temp));
                return out;
            }
        }
        return out;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
//commented out by Simon
    private List<Integer> findK(List<Integer> selectedCards) {
        List<String> test = new ArrayList<String>();
        List<Integer> out = new ArrayList<Integer>();
        for(int i = 0; i < selectedCards.size(); i++)
            test.add(cardAt(selectedCards.get(i)).getRank());
        if (test.contains("king")) {
            out = selectedCards;
//            System.out.println(out.toString() + "hey look at this!");
        }
        return out;
    }
}
