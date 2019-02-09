package stateandbehavior;

public class UpOrDownCounter {
	
	public UpOrDownCounter(int start, int end) {
		if( start == end) {
			throw new IllegalArgumentException("start can't be the "
					+ "same as end");
		}
		this.startValue = start;
		this.endValue = end;
		this.counter = start;
	}
	
	private int startValue;
	private int endValue;
	private int counter;
	
	public int getCounter() {
		return counter;
	}
	
	public boolean count() {
		if(this.startValue < this.endValue) {
			this.counter = this.counter + 1;
			if(this.counter == this.endValue) {
				this.counter = this.startValue;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			this.counter = this.counter - 1;
			if(this.counter == this.endValue) {
				this.counter = this.startValue;
				return true;
			}
			else {
				return false;
			}			
		}
	}
	
	public String toString() {
		return "The counter is currently at "+this.counter;
	}
	
	
	public static void main(String[] args) {
		UpOrDownCounter counter = new UpOrDownCounter(0, 5);
		System.out.println(counter);
		System.out.println();
		System.out.println(counter.count());
		System.out.println(counter.count());
		System.out.println(counter);
		System.out.println(counter.count());
		System.out.println(counter.count());
		System.out.println(counter);
		System.out.println(counter.count());
		
		
	}

}
