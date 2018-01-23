
/**
 * @author Stephen_Wagstaff
 *
 */
public class smartDeck extends Deck{
	
// Instance variables
	private int cardsDealt;

// Setters and Getters
	/**
	 * @return the cardsDealt
	 */
	private int getCardsDealt() {
		return cardsDealt;
	}
	
	/**
	 * Sets the number of cards dealt and check that the new number is between 0 and 51 inclussive
	 * @param numDealt
	 */
	private void setCardsDealt(int numDealt){
		if(numDealt <= 52 && numDealt >= 0)
			cardsDealt = numDealt;
	}

	/**
	 * Resets the cardsDealt value back to 0
	 */
	private void resetCardsDealt() {
		this.cardsDealt = 0;
	}


// Constructor
	/**
	 * Default constructor
	 */
	public smartDeck() {
		super();
		this.cardsDealt = 0;
	}

// Instance Methods
	/**
	 * set the values of deck to indicate that they are all present (true) - not
	 * dealt yet, and resets the cardsDealt counter to 0
	 * 
	 */
	public void initDeck(){
		super.initDeck();
		this.resetCardsDealt();
	}
	
	/**
	 * returns whether or not all the cards in the deck have already been dealt.
	 * 
	 * @return boolean value if the deck is empty
	 */
	public boolean emptyDeck() {
		return !(this.getCardsDealt() <= 52);
	}
	
	/**
	 * returns a card (an int in the range 0 to 51) at random that has not been
	 * dealt since the deck was initialize via intDeck. Also notes (in deck)
	 * that this card is no longer available. Returns 100 if there is an error. 
	 * 
	 * @return int of the newly dealt card (0-51)
	 */
	public int dealCard() {
		if(!this.emptyDeck()){
			this.setCardsDealt(this.getCardsDealt()+1);
			return super.dealCard();
		}
		return 100;                          // Continue the error indication of a return value of 100 
	}
	
}
