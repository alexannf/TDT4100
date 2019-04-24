package interfaces;



public class Card implements Comparable<Card>{
	
	// face = "value" on the card, suit = "type"
		public Card(char suit, int face) {
			if(!isValidSuit(suit)) {
				throw new IllegalArgumentException(
						"suit must be of type 'S', 'H', 'D' or 'C'");
			}
			if(!isValidFace(face)) {
				throw new IllegalArgumentException(
						"face must be a value between and incluing 1-13");			
			}
			this.suit = suit;
			this.face = face;
		}
		
		private char suit;
		private int face;

		public char getSuit() {
			return this.suit;
		}
		public int getFace() {
			return this.face;
		}
		
		private boolean isValidSuit(char suit) {
			if(suit ==  'S' || suit == 'H' || suit == 'D' || suit == 'C') {
				return true;
			}
			return false;
		}
		
		private boolean isValidFace(int face) {
			if(face < 1 || face > 13) {
				return false;
			}
			return true;
		}
		
		public String toString() {
			return ""+this.suit+this.face;
		}
		
		@Override
		public int compareTo(Card otherCard) {
			if(this.suit == 'S') {
				if(otherCard.suit == 'S') {
					if(this.face > otherCard.face) {
						return 1;
					}
					else if(this.face == otherCard.face) {
						return 0;
					}
					return -1;
				}
				return 1; //if not S "otherCard" har "smaller" value
							// and thisCard has larger value (1) 
				
			}
			else if(this.suit== 'H') {
				if(otherCard.suit == 'S') {
					return -1;
				}
				else if(otherCard.suit == 'H') {
					if(this.face > otherCard.face) {
						return 1;
					}
					else if(this.face == otherCard.face) {
						return 0;
					}
					return -1;
				}
				return 1; // possibility of otherCard being bigger or
							// even is eliminated, it must be smaller
			}
			else if(this.suit== 'D') {
				if(otherCard.suit == 'S' || otherCard.suit == 'H') {
					return -1;
				}
				else if(otherCard.suit == 'D') {
					if(this.face > otherCard.face) {
						return 1;
					}
					else if(this.face == otherCard.face) {
						return 0;
					}
					return -1;
				}
				return 1; // possibility of otherCard being bigger or
							// even is eliminated, it must be smaller
			}
			// suit must be 'C', which is ranked the lowest
			else {
				if(otherCard.suit != 'C') {
					return -1;  //  this card is ranked lower
				}
				if(this.face > otherCard.face) {
					return 1;
				}
				else if(this.face == otherCard.face) {
					return 0;
				}
				return -1;
			}
		}
		
	
		
}
