package encapsulation;

public class VehicleV1 {
	
	public VehicleV1(char typeOfVehicle, char fuelType, String regNr) {
		if(!isValidVehicleType(typeOfVehicle)) {
			throw new IllegalArgumentException("not valid vehicle type");
		}
		if(!isValidFuelType(fuelType)) {
			throw new IllegalArgumentException("not valid fuel type");
		}
		if(!isValidRegNr(typeOfVehicle, fuelType, regNr)) {
			throw new IllegalArgumentException("not valid regNr");
		}
		this.typeOfVehicle = typeOfVehicle;
		this.fuelType = fuelType;
		this.regNr = regNr;
	}
	
	private char typeOfVehicle;
	private char fuelType;
	private String regNr;
	
	
	private boolean isValidVehicleType(char vehicleChar) {
		if((vehicleChar == 'M') || (vehicleChar == 'C')) {
			return true;
		}
		else {
			return false;
		}
	}
	 
	private boolean isValidFuelType(char fuelType) {
		if((fuelType == 'H') || (fuelType == 'G') || (fuelType == 'D')) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isValidRegNr(char typeOfVehicle, 
			char fuelType, String regNr) {
		// first two letters in registration number
		String regSubString = regNr.substring(0,2);
		String regNrs = regNr.substring(2);
		if(fuelType == 'H') {
			if((!regSubString.equals("HY") || typeOfVehicle == 'C')){
				return false;
			}
		}
		if(fuelType == 'E') {
			if(!(regSubString.equals("EL")|| regSubString.equals("EK"))){
				return false;
			}
		}
		if((fuelType =='G' || fuelType =='D')&&
				(regSubString.equals("EK")||
						regSubString.equals("EL")||
								regSubString.equals("HY"))) {
			return false;
		}
		if(!isCapitalAlpha(regSubString)) {
			return false;
		}
		if(!isOnlyNumbers(regNrs)) {
			return false;
		}
		if(typeOfVehicle == 'C'){
				if(regNrs.length() != 5) {
			return false;
				}	
		}
		if(typeOfVehicle == 'M'){
				if(regNrs.length() != 4 || fuelType == 'H'){
			return false;
				}
		}
		return true;
	}
	
	// tests if string contains only capital alphabetic(A-Z) letters
	private boolean isCapitalAlpha(String testString) {
		char[] chars = testString.toCharArray();
		for (char c : chars) {
			if(!(Character.isUpperCase(c) && Character.isLetter(c))) {
				return false;
			}
		}
		return true;
	}
	
	// tests if string contains only numbers
	private boolean isOnlyNumbers(String testString) {
		char[] chars = testString.toCharArray();
		for (char c : chars) {
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
	
	public void setRegistrationNumber(String newRegNr) {
		if(!isValidRegNr(this.typeOfVehicle, this.fuelType, newRegNr)) {
			throw new IllegalArgumentException("not valid regNr");
		}
		this.regNr = newRegNr;
	}
	public String getRegistrationNumber() {
		return this.regNr;
	}
	
	public char getFuelType() {
		return this.fuelType;
	}
	
	public char getVehicleType() {
		return this.typeOfVehicle;
	}

	public static void main(String[] args) {
		VehicleV2 car = new VehicleV2('C', 'D', "FG23456");
		System.out.println(car.getFuelType());
		System.out.println(car.getRegistrationNumber());
		System.out.println(car.getVehicleType());
	}

}
