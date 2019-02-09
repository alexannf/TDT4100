package stateandbehavior;

public class Digit {
	
	public Digit(int numberSystem) {
		this.numberSystem = numberSystem;
		this.number = 0;
	}
	
	private int numberSystem;
	private int number;
	
	public int getValue() {
		return this.number;
	}
	
	public boolean increment() {
		if(this.number + 1 == this.numberSystem) {
			this.number = 0;
			return true;
		}
		else {
			this.number = this.number+1;
			return false;
		}
	}
	
	public int getBase() {
		return this.numberSystem;
	}
	
	public String toString() {
		if (this.number > 9) {
			return ""+ (char) (number+55);  //ASCII "A" starts at value 65
		}
		else {
			return ""+this.number;
		}
	}
	
	public static void main(String[] args) {
		Digit numSys1 = new Digit(10);
		Digit numSys2 = new Digit(16);
		
		System.out.println(numSys2);
		System.out.println();  // extra line for nicer console ouput
		numSys2.increment();
		numSys2.increment();
		numSys2.increment();
		numSys2.increment();
		numSys2.increment();
		numSys2.increment();
		numSys2.increment();
		numSys2.increment();
		numSys2.increment();
		numSys2.increment();  // 10 times to get test for "10-A"
		System.out.println(numSys2);
		
	}

}
