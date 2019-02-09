package stateandbehavior;

public class Account {
	
	private double balance;
	private double interestRate;
	
	public void deposit(double amount) {
		if(amount <= 0) {
		}
		else {
			this.balance = this.balance + amount;			
		}
	}
	
	/*
	Account-klassen har fem metoder, med f�lgende oppf�rsel:

	deposit(double) - �ker konto-bel�pet med den angitte argument-verdien (et desimaltall), men kun dersom det er positivt
	addInterest() - beregner renta og legger det til konto-bel�pet
	getBalance() - returnerer bel�pet som er p� kontoen. 
	getInterestRate() - returnerer rentefoten
	setInterestRate(double) - oppdaterer renten til � v�re den nye verdien
	 */
	
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
		this.interestRate = newRate;
	}
	
	public static void main(String [ ] args) {
		Account acc1 = new Account();
		acc1.deposit(1000);
		System.out.println(acc1.getBalance());
	}

}
