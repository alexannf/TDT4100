package interfaces;

public class Person1 implements Named{
	
	private String givenName;
	private String familyName;
	private String fullName;
	
	
	public Person1(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
		this.fullName = givenName + " " + familyName;
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
