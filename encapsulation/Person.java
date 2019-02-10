package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Person {
	
	List<String> countryCodeList = new ArrayList<String>
	(Arrays.asList(new String[] 
			{"ad", "ae", "af", "ag", "ai", "al", "am", 
           "ao", "aq", "ar", "as", "at", "au", "aw", "ax", 
           "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", 
           "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", 
           "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", 
           "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", 
           "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", 
           "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", 
           "ee", "eg", "eh", "er", "es", "et", "fi", "fj", 
           "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", 
           "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", 
           "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", 
           "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", 
           "im", "in", "io", "iq", "ir", "is", "it", "je", 
           "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km",
           "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb",
           "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv",
           "ly", "ma", "mc", "md", "me", "mf", "mg", "mh",
           "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr",
           "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", 
           "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", 
           "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", 
           "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", 
           "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", 
           "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", 
           "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", 
           "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", 
           "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", 
           "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", 
           "um", "us", "uy", "uz", "va", "vc", "ve", "vg", 
           "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", 
           "zm", "zw"}));

	private String firstName;
	private String lastName;
	private Date birthday;
	private String email;
	private char gender;
	
	public void setBirthday(Date newBirthday) {
		Date now = new Date();
		if(newBirthday.after(now)) {
			throw new IllegalArgumentException("illegal birthday");
		}
		this.birthday = newBirthday;
	
	// fikk ikke denne delen av koden til å funke, Date er uansett utdatert
	// er Calendar som gjelder naa :)
	/*	
	public Date getBirthday() {
		return this.birthday;
	}
	*/
		
	}
	// used for testing in SetName
	private boolean isInvalidName(String name) {
		String[] splitName = name.split(" "); //[] means array variable
		if(splitName.length != 2) {
			return true;
		}
		if((splitName[0].length() < 2) || (splitName[1].length() < 2)){		
			return true;
		}
		// must remove space to test for alphabetic characters
		String oneStringName = name.replace(" ","");
		if(isNotAlpha(oneStringName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// tests if input String is only alphabetic characters
	public boolean isNotAlpha(String testString) {
		char[] chars = testString.toCharArray();
		for (char c : chars) {
			if(!Character.isLetter(c)) {
				return true;
			}
		}
		return false;
		
	}
	
	public void setName(String newName) {
		if(isInvalidName(newName)) {
			throw new IllegalArgumentException("not valid name");
		}
		String[] firstLastName = newName.split(" ");
		this.firstName = firstLastName[0];
		this.lastName = firstLastName[1];
		
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	// used for testing in setEmail
	private boolean isInvalidMail(String mail) {
		// edge case for splitting ".", -1 avoids another exception thrown
		String[] splitMail = mail.split("\\.",-1); 
		if(splitMail.length != 3) {
			return true;
		}
		String[] innerSplit = splitMail[1].split("@");
		if(innerSplit.length !=2) {
			return true;
		}
		// define parts in mail after 
		String mailFirstName = splitMail[0];
		String countryCode = splitMail[2];
		String mailLastName = innerSplit[0];
		String domain = innerSplit[1];  // no rule for domain
		// testing countryCode
		if(!this.countryCodeList.contains(countryCode)) {
			return true;
		}
		// testing if firstname in mail matches person
		if(!mailFirstName.toLowerCase().equals(this.firstName.toLowerCase())) {
			return true;
		}
		// testing if lastname in mail matches person
		if(!mailLastName.toLowerCase().equals(this.lastName.toLowerCase())) {
			return true;
		}
		String testString = mailFirstName + mailLastName;
		// testing if mail contains illegal characters
		if(isNotAlpha(testString)) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public void setEmail(String newMail) {
		if(isInvalidMail(newMail)) {
			throw new IllegalArgumentException("not valid Email");
		}
		this.email = newMail;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setGender(char newGender) {
		if(!((newGender == 'M') || (newGender == 'F') || 
				(newGender == '\0'))) {
			throw new IllegalArgumentException("Invalid gender");
		}
		this.gender = newGender;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	
	public static void main(String[] Args) {
		Person alex = new Person();
		alex.setName("Ola Nordmann");
		System.out.println(alex.getName());
		alex.setEmail("ola.nordmann@ntnu3245324.no");
	}
}
