package stateandbehavior;

public class Location {
	
	private int xPosition;
	private int yPosition;
	
	public void up() {
		this.yPosition = this.yPosition - 1;
	}
	
	public void down() {
		this.yPosition = this.yPosition + 1;
	}
	
	public void left() {
		this.xPosition = this.xPosition - 1;
	}

	public void right() {
		this.xPosition = this.xPosition + 1;
	}
	
	public int getX() {
		return this.xPosition;
	}
	
	public int getY() {
		return this.yPosition;
	}
	
	public String toString() {
		return "X-location is "+this.xPosition +" and Y-location is "
				+this.yPosition;
	}
	
	public static void main(String[] args) {

		Location newLocation = new Location();
		System.out.println(newLocation);
	}

}
