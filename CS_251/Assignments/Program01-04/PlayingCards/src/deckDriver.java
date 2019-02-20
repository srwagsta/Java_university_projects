/**
 * @author Stephen_Wagstaff
 *
 */
public class deckDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println("INITIALIZING DECK ....  \n" + deck);

		deck.shuffleDeck();
		
		System.out.println("\nSHUFFLING DECK .... \n" + deck);
		
		
		System.out.print("\nDEALING 42 CARDS .... ");
		for(int i = 0; i<42; i++) {
			if(i%7 == 0)
				System.out.println();
			System.out.printf("%5s",deck.dealCard());
		}
		System.out.println("\n\nNumber of cards dealt: " + deck.getCardsDealt());
		
	}

}
