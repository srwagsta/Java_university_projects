/**
 * @author Stephen_Wagstaff
 * Test class for the Card class
 */
import java.util.concurrent.ThreadLocalRandom; // Import for use in getting a random number for dealCard()

public class cardDriver {

	private static final String[] suits = {"C","S","H","D"};
	private static final String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	/**
	 * Finds the Queen of Clubs in a passed array of Cards
	 * 
	 * @param Deck (an array of Cards, of any length) 
	 * @return index of the queen of clubs
	 */
	private static int findTheQueen(Card[] Deck){
		for(int i=0;i<Deck.length;i++){
			if(Deck[i].toString().equals("CQ"))
				return i;
		}
		return 100;                                                   // Error return 
	}
	
	/**
	 * Finds two random indices (0-51) and swaps the card at these locations
	 * 
	 * @param Deck
	 */
	private static void swapCard(Card[] Deck){
		int card1, card2; 
		do{
			card1 = ThreadLocalRandom.current().nextInt(0, 51);
			card2 = ThreadLocalRandom.current().nextInt(0, 51);
		} while(card1 == card2);
		Card temp = new Card(Deck[card1]);
		Deck[card1] = new Card(Deck[card2]);
		Deck[card2] = temp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Card[] Deck = new Card[52];
		
		for(int i = 0;i<52;){                                         // Start nested loops to fill the Deck array with unique   
			for (String setSuit : suits){                             // cards in the order for the class suits and ranks arrays
				for(String setRank : ranks){
					Deck[i] = new Card(setSuit,setRank);
					i++;
				}}}                                                   // Close all for loops
		
// 100 card swaps
		for(int i = 0; i<100;i++){
			cardDriver.swapCard(Deck);
		}
		
// Print all of the card in the Deck
		System.out.println("Deck: ");
		for(int i = 0; i < 52; i++){
			System.out.printf("%5s",Deck[i].toString());
			if((i+1)%7 == 0)
				System.out.println();
		}

// Find the Queen of Clubs in the Deck		
		System.out.print("\n\nIndex of the Queen of Clubs: " + cardDriver.findTheQueen(Deck));
		
	}

}
