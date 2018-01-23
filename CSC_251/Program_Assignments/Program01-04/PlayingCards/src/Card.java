/**
 * @author Stephen_Wagstaff
 *
 */
public class Card {
// Instance variables
	private String suit;
	private String rank;
	
// Constructors 
	/**
	 * Default constructor, by default the card will be Ace of Club (CA)
	 */
	public Card(){
		suit = "C";
		rank = "A";
	}
	
	/**
	 * Specifying constructor
	 */
	public Card(String suit, String rank){
		this.setRank(rank);
		this.setSuit(suit);
	}
	
	/**
	 * Copy constructor
	 */
	public Card(Card copy){
		this.setRank(copy.getRank());
		this.setSuit(copy.getSuit());
	}
	
// Setters and Getters
	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}
	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	
	/**
	 * @param suit the suit to set
	 */
	private void setSuit(String suit) {
		String[] possSuites = {"C","D","H","S"};
		for(String testSuit : possSuites){
			if(suit.equalsIgnoreCase(testSuit)){
				this.suit = suit;
				return;
			}
		}
	}
	
	/**
	 * @param rank the rank to set
	 */
	private void setRank(String rank) {
		String[] possRank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(String testRank : possRank){
			if(rank.equalsIgnoreCase(testRank)){
				this.rank = rank;
				return;
			}
		}
	}
	
// Instance Methods
	
	/**
	 * Clone method, allows  for a deep copy of a Card object 
	 * 
	 * @param copy
	 * @return a deep copy of the passed Card
	 */
	public Card clone(Card copy){
		return new Card(copy);
	}

	/**
	 * Compare the Suit and Rank of this card to the passed card
	 *  
	 * @param guest
	 * @return the boolean value of the comparison 
	 */
	public boolean equals(Card guest){
		return (this.getRank().equals(guest.getRank()) && this.getSuit().equals(guest.getSuit()));
	}
	
	/**
	 * The standard toString method, it's not pretty but the format is easy to use in future classes
	 * 
	 * @return the string representation if the form "suitrank"
	 */
	public String toString(){
		return this.getSuit() + this.getRank();
	}
	
}
