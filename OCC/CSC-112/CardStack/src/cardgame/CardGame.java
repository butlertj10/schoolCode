package cardgame;

/**
 * CardGame main class
 * 
 * @author Trevor
 */
public class CardGame 
{
    /**
     * Displays whole deck and draws a card
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        DeckOfCards deck = new DeckOfCards();

        System.out.println("Whole Deck: \n");
        
        // show the whole deck
        deck.DisplayDeck();
        
        System.out.println("\nYour card is " + deck.pop().toString());
        System.out.println("Your card is " + deck.pop().toString());
        System.out.println("Your card is " + deck.pop().toString());
    }
}
