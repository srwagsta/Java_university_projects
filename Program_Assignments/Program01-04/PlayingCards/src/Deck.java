
/**
 * @author Stephen_Wagstaff
 * Create a class that emulates a deck of playing cards. 
 * This includes 4 suits (Clubs, Spades, Hearts, and Diamonds) 
 * 13 ranks (Ace, 2, 3, 4, 5, 6, 7, 8, 9, Jack, Queen, King) 
 * Making for a total of 52 playing cards in the deck
 * 
 */
import java.util.concurrent.ThreadLocalRandom; // Import for use in getting a random number for dealCard()

public class Deck {

// Class variables
	private static final String[] suits = {"C","S","H","D"};
	private static final String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
// Instance variables
	private Card[] deck = new Card[52]; 
	private int cardsDealt;
	
// Constructors
	/**
	 * Default constructor, gives each reference in the deck array a value.
	 */
	public Deck() {
		for(int i = 0;i<52;){                                         // Start nested loops to fill the Deck array with unique   
			for (String setSuit : suits){                             // cards in the order for the class suits and ranks arrays
				for(String setRank : ranks){
					deck[i] = new Card(setSuit,setRank);
					i++;
				}}}                                                   // Close all for loops
		cardsDealt = 0;
	}

// Setters and Getters
	/**
	 * @return the number of cards dealt
	 */
	public int getCardsDealt() {
		return this.cardsDealt;
	}
	
	/**
	 * mutator for the cardsDealt variable
	 * @param cardsDealt
	 */
	private void setCardsDealt(int cardsDealt) {
		this.cardsDealt = cardsDealt;
	}
	
// Instance methods	
	/**
	 * returns whether or not all the cards in the deck have already been dealt. Based on the cardDealt value.
	 * @return boolean value if the deck is empty
	 */
	public boolean emptyDeck() {
		return this.getCardsDealt() == 52; 
	}
	
	/**
	 * Resets the cardsDealt variable using the class mutator
	 */
	public void collectCards() {
		this.setCardsDealt(0);
	}
	
	/**
	 * Decrements the cardsDealt by cardCnt
	 * @param cardCnt
	 */
	public void collectCards(int cardCnt) {
		this.setCardsDealt((this.getCardsDealt()-cardCnt));
	}
	/**
	 * Returns the next card in the deck given that there are still cards left in the deck.
	 * If the deck is empty null is returned. The cardsDealt counter is incremented. 
	 * 
	 * @return next card in the deck
	 */
	public Card dealCard() {
		if (!this.emptyDeck()) {
			this.setCardsDealt(this.getCardsDealt()+1);
			return deck[this.getCardsDealt()-1];
		}else return null;
	}
	
	/**
	 * apply swapCnt number of random card swaps within the deck.
	 * warning - the deck is accessed directly within this method
	 * 
	 * @param swapCnt
	 */
	public void shuffleDeck(int swapCnt) {
		for(int i=0;i<swapCnt;i++) {
			int card1, card2; 
			do{
				card1 = ThreadLocalRandom.current().nextInt(0, 52);
				card2 = ThreadLocalRandom.current().nextInt(0, 52);
			} while(card1 == card2);
			Card temp = new Card(this.deck[card1]);
			this.deck[card1] = new Card(this.deck[card2]);
			this.deck[card2] = temp;
		}
	}

	/**
	 * apply 100 random card swaps within the deck.
	 * warning - the deck is accessed directly within this method
	 */
	public void shuffleDeck() {
		this.shuffleDeck(100);
	}
	
	/**
	 * Passed a card a representation of the card is printed
	 * 
	 * @param card
	 */
	public String toString() {
		String output = "";
		for(int i = 0; i < 52; i++){
			output+= String.format("%5s",this.deck[i].toString());
			if((i+1)%7 == 0)
				output += "\n";
		}
		return output;
	}

}
