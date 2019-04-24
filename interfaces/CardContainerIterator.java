package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card>{
	
	private CardContainer cardContainer;
	private int position;
	
	public CardContainerIterator(CardContainer cardContainer) {
		this.cardContainer = cardContainer;
		this.position = 0;
		
	}
	
	/*
	 * CardContainer methods:
	 * int getCardCount();
	 * Card getCard(int n);
	 */

	@Override
	// checks if we have reached the "end" of the cardList
	// but we remember that we can only access data through CardContainer
	// methods
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return position < cardContainer.getCardCount();
	}



	@Override
	// returns current position in cardlist and will return next position
	// if called again
	public Card next() {
		Card card = cardContainer.getCard(position);
		position ++;
		return card;
	}

}
