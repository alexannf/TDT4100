package interfaces;

public class Person2 implements Named{
	
	private String givenName;
	private String familyName;
	private String fullName;
	
	
	public Person2(String fullName) {
		this.fullName = fullName;
		String[] names = fullName.split(" ");
		this.givenName = names[0];
		this.familyName = names[1];
	}

	@Override
	public void setGivenName(String givenName) {
		this.givenName = givenName;
		
	}

	@Override
	public String getGivenName() {
		return this.givenName;
	}

	@Override
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
		
	}

	@Override
	public String getFamilyName() {
		return this.familyName;
	}

	@Override
	public void setFullName(String fullName) {
		this.fullName = fullName;
		
	}

	@Override
	public String getFullName() {
		return this.fullName;
	}
	
	@Override
	public String toString() {
		return this.fullName;
	}

}
