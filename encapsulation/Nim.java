package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nim {
	
	public Nim() {
		this.pileList = new ArrayList<Integer>(
				Arrays.asList(10,10,10));
	}
	
	public Nim(int pileSize) {
		this.pileList = new ArrayList<Integer>(
				Arrays.asList(pileSize,pileSize,pileSize));
		
	}
	
	private List<Integer> pileList;
	
	
	public void removePieces(int number, int targetPile) {
		if(isGameOver()) {
			throw new IllegalStateException(
					"can't move when the game is over");
		}
		if(!isValidMove(number, targetPile)) {
			throw new IllegalArgumentException("not valid move");
		}
		else {
			this.pileList.set(
					targetPile, pileList.get(targetPile)-number);
		}
	}
	
	public boolean isValidMove(int number, int targetPile) {
		if(targetPile < 0 || targetPile > 2) {
//			throw new IllegalArgumentException(
//					"target pile must be 0, 1 or 2");
			return false;
		}
		if(number < 1 || number > this.getPile(targetPile)) {
//			throw new IllegalArgumentException(
//					"number must be from 1-"+this.getPile(targetPile));
			return false;
		}
		if(isGameOver()) {
			return false;
		}
		else {
//			this.pileList.set(
//					targetPile, pileList.get(targetPile)-number);
			return true;
		}
	}
	
	public boolean isGameOver() {
		if(pileList.contains(0)) {
			return true;
		}
		return false;
	}
	
	public int getPile(int targetPile) {
		if(targetPile < 0 || targetPile > 2) {
			throw new IllegalArgumentException(
					"target pile must be 0, 1 or 2");
		}
		return pileList.get(targetPile);
	}
	
	public String toString() {
		return "pile 0 has "+this.getPile(0)+
				" pieces, pile 1 has "+this.getPile(1)+
				"pieces & pile 2 has "+this.getPile(2)+" pieces.";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
