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
	Account-klassen har fem metoder, med følgende oppførsel:

	deposit(double) - øker konto-beløpet med den angitte argument-verdien (et desimaltall), men kun dersom det er positivt
	addInterest() - beregner renta og legger det til konto-beløpet
	getBalance() - returnerer beløpet som er på kontoen. 
	getInterestRate() - returnerer rentefoten
	setInterestRate(double) - oppdaterer renten til å være den nye verdien
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
