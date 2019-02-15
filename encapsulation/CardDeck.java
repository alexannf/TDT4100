package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDeck {
	
	//size of card deck will be 4 times "n" (even number)
	public CardDeck(int n) {
		if(!isValidFace(n)) {
			throw new IllegalArgumentException(
					"a card deck must have 1-13 different faces");			
		}
		validSuits = new ArrayList<Character>(
				Arrays.asList('S', 'H', 'D','C'));
		cardDeck = new ArrayList<Card>();
		makeCardDeck(n);
	}
	
	
	private List<Character> validSuits;
	private List<Card> cardDeck;
	
	private boolean isValidFace(int face) {
		if(face < 0 || face > 13) {
			return false;
		}
		return true;
	}
	
	private void makeCardDeck(int n){
		//iterates 4 times, one for each suit
		for(int i=0;i<4;i++) {
			for(int j=1; j<=n;j++) {
				cardDeck.add(new Card(validSuits.get(i), j));
			}
		}
		
	}
	
	public int getCardCount() {
		return this.cardDeck.size();
	}
	
	// n is just card nr. "n" in the deck, we can't know which one it is
	// if we shuffle
	public Card getCard(int n) {
		if(n>this.getCardCount()-1) {
			throw new IllegalArgumentException(
					"we don't have that many cards");
		}
		return cardDeck.get(n);
	}
	
	public void shufflePerfectly() {
		// this works because we can't remove cards from the deck yet, thus
		//we will always have a even number of cards(see constructor)
		List<Card> firstHalf = cardDeck.subList(0, getCardCount()/2);
		List<Card> secondHalf = cardDeck.subList(
				getCardCount()/2, getCardCount());
		List<Card> newOrder = new ArrayList<Card>();
		// by using add we will place at end of array and get wished result
		for(int i=0;i<getCardCount()/2;i++) {
			newOrder.add(firstHalf.get(i));
			newOrder.add(secondHalf.get(i));
		}
		cardDeck = newOrder;
	}
	
	public String toString() {
		return "current deck looks like: "+this.cardDeck;
	}
	
	
	public static void main(String[] args) {
		CardDeck newDeck = new CardDeck(2);
		System.out.println(newDeck);
		newDeck.shufflePerfectly();
		System.out.println(newDeck);

	}

}
