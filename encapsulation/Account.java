package encapsulation;

public class Account {
	
	public Account(double startValue, double interestRate) {
		if((startValue < 0)|| (interestRate < 0)) {
			throw new IllegalArgumentException("values can't be negative");
		}
		this.balance = startValue;
		this.interestRate = interestRate;
	}
	
	private double balance;
	private double interestRate;
	
	public void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("values can't be negative");			
		}
		else {
			this.balance = this.balance + amount;			
		}
	}
	
	public void withdraw(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("values can't be negative");			
		}
		else if((this.balance - amount) < 0) {
			throw new IllegalArgumentException("you can't withdraw more"
					+ " money than you have");			
		}
		else {
			balance = balance - amount;
		}
	}
	
	public void addInterest() {
			this.balance = this.balance + (this.balance * (this.interestRate/100));
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double newRate) {
		if(newRate < 0) {
			throw new IllegalArgumentException("can't be negative");
		}
		this.interestRate = newRate;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
