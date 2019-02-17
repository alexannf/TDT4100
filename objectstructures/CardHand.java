package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class CardHand {
	
	public CardHand() {
		cardHand = new ArrayList<Card>();
	}
	
	private List<Card> cardHand;
	
	public int getCardCount() {
		return this.cardHand.size();
	}
	
	// n is just card nr. "n" in the deck, we can't know which one it is
	// if we don't know what card is placed at the n-th spot
	public Card getCard(int n) {
		if(n>this.getCardCount()-1) {
			throw new IllegalArgumentException(
					"we don't have that many cards");
		}
		return cardHand.get(n);
	}
	
	public void addCard(Card newCard) {
		if(!this.cardHand.contains(newCard)) {
			this.cardHand.add(newCard);			
		}
		
	}
	
	public Card play(int n) {
		Card playedCard = cardHand.get(n);
		cardHand.remove(n);
		return playedCard;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
