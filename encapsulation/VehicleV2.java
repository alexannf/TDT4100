package encapsulation;

public class VehicleV2 {
	
	public VehicleV2(char typeOfVehicle, char fuelType, String regNr) {
		if(!isValidFuelType(fuelType)) {
			throw new IllegalArgumentException("fuel not correct");
		}
		if(!isValidVehicleType(typeOfVehicle)) {
			throw new IllegalArgumentException("vehicle not correct");			
		}
		if(!isValidFuelVehicleDependency(typeOfVehicle, fuelType)) {
			throw new IllegalArgumentException(
					"this type of vehicle can't have hydrogen");
		}
		if(!isValidRegNumbers(typeOfVehicle, regNr)) {
			throw new IllegalArgumentException(
					"RegNr either contains non-numbers or have the "
					+ "wrong length");
		}
		if(!isValidRegLetters(fuelType, regNr)) {
			throw new IllegalArgumentException(
					"RegNr either contains non-alphabetic-letters "
					+ "or have the wrong format according to fuel");
		}
		this.typeOfVehicle = typeOfVehicle;
		this.fuelType = fuelType;
		this.regNr = regNr;
	}
	
	private char typeOfVehicle;
	private char fuelType;
	private String regNr;
	
	// checks if type of vehicle is 'M' motorcycle or 'C' car
	private boolean isValidVehicleType(char vehicleChar) {
		if((vehicleChar == 'M') || (vehicleChar == 'C')) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// checks if type of fuel is 'H', 'E, 'D' or 'G'
	private boolean isValidFuelType(char fuelType) {
		if((fuelType == 'H') || (fuelType == 'G') || 
				(fuelType == 'D') || fuelType == 'E') {
			return true;
		}
		else {
			return false;
		}
	}
	
	// edge case if vehicle = Motorcycle and fuel = Hydrogen
	private boolean isValidFuelVehicleDependency(char vehicle, char fuel) {
		if(vehicle == 'M' && fuel == 'H') {
			return false;
		}
		return true;
	}
	
	// checks if Number format in RegNr is correct
	private boolean isValidRegNumbers(char vehicle, String regNr) {
		String regNrs = regNr.substring(2);
		if(vehicle == 'M') {
			if(isOnlyNumbers(regNrs) && regNrs.length() == 4) {
				return true;
			}
			else {
				return false;
			}
		}
		// if not 'M' we know it must be 'C'
		else {
			if(isOnlyNumbers(regNrs) && regNrs.length() == 5) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	// checks if Letters in RegNr is correct (depends on fuel)
	private boolean isValidRegLetters(char fuel, String regNr) {
		String regLetters = regNr.substring(0,2);
		if(fuel == 'H') {
			if(regLetters.equals("HY") && isCapitalAlpha(regLetters)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(fuel == 'E'){
			if((regLetters.equals("EL")||regLetters.equals("EK")) && isCapitalAlpha(regLetters)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if(isCapitalAlpha(regLetters)) {
				return true;
			}
			else {
				return false;
			}
		}
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
	
	public char getFuelType() {
		return fuelType;
	}
	
	public String getRegistrationNumber() {
		return regNr;
	}
	
	public char getVehicleType() {
		return typeOfVehicle;
	}

	public void setRegistrationNumber(String newRegNr) {
		char currVehicle = this.typeOfVehicle;
		char currfuel = this.fuelType;
		if(!isValidRegLetters(currfuel, newRegNr)) {
			throw new IllegalArgumentException(
					"RegNr either contains non-alphabetic-letters "
					+ "or have the wrong format according to fuel");
		}
		if(!isValidRegNumbers(currVehicle, newRegNr)) {
			throw new IllegalArgumentException(
					"RegNr either contains non-numbers or have the "
					+ "wrong length");
		}
		this.regNr = newRegNr;
	}
	
	public static void main(String[] args) {
		VehicleV2 gasCar = new VehicleV2('C', 'D', "TY12345");
		gasCar.setRegistrationNumber("AÆ12345");
		System.out.println(gasCar.getRegistrationNumber());

	}
}
