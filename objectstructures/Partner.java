package objectstructures;

public class Partner {
	
	public Partner(String name) {
		this.name=name;
	}
	
	private String name;
	private Partner partner;
	
	public String getName() {
		return name;
	}
	
	public Partner getPartner() {
		return this.partner;
	}
	
	public void setPartner(Partner newPartner) {
		// if this is correct we can just jump out of the method-call
		if (this.partner == newPartner) {
			return;
		}		
		
		Partner oldPartner = this.partner;
		this.partner = newPartner;
		// if old partner was null we don't have to update our old partner
		if (oldPartner != null && oldPartner.getPartner() == this) {
			oldPartner.setPartner(null);
		}
		// this is for our partner to update us, but we must 
		// avoid nullPointerException (a "null" can't set us as partner)
		if(this.partner != null) {
			this.partner.setPartner(this);
		}
	}
	@Override
	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		Partner p1 = new Partner("Alex");
		Partner p2 = new Partner("Gal Gadot");
		Partner p3 = new Partner("Lady Gaga");
		Partner p4 = new Partner("Zac Efron");
		
		p1.setPartner(p2);
		System.out.println(p1.getPartner());
		System.out.println(p2.getPartner());
		System.out.println(p3.getPartner());
		p1.setPartner(p3);
		System.out.println(p1.getPartner());
		System.out.println(p3.getPartner());
		p2.setPartner(p4);
		p1.setPartner(p2);
		

	}

}
