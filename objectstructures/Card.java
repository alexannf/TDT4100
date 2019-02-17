package objectstructures;

public class Card {
	
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
		
		public static void main(String[] args) {
			Card S1 = new Card('S', 1);
			System.out.println(S1);

		}

}
