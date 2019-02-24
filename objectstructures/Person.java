package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name;
	private char gender;
	private Person mother;
	private Person father;
	private List<Person> children = new ArrayList<Person>();
	
	public Person(String name, char gender) {
		if(!isValidGender(gender)) {
			throw new IllegalArgumentException("wrong gender input");
		}
		this.name=name;
		this.gender=gender;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public Person getMother() {
		return this.mother;
	}
	
	public Person getFather() {
		return this.father;
	}
	
	public int getChildCount() {
		return children.size();
	}
	
	public Person getChild(int n) {
		if(n<0 || n >= this.getChildCount()) {
			throw new IllegalArgumentException("wrong input");
		}
		return children.get(n);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public boolean isValidGender(char gender) {
		if(!((gender == 'M') || (gender == 'F'))) {
			return false;
		}
		return true;
	}
	
	public void addChild(Person child) {
		if(isSelf(child)) {
			throw new IllegalArgumentException("illegal argument");
		}
		if(this.children.contains(child)) {
			return;
		}
		this.children.add(child);
		if(this.getGender() == 'F') {
			child.setMother(this);
		}
		else {
			child.setFather(this);
		}
		
		
	}
	// no reason here why the input will be null
	public void removeChild(Person child) {
		if(isSelf(child)) {
			throw new IllegalArgumentException("illegal argument");
		}
		if(this.children.contains(child)) {
			this.children.remove(child);
		}
		if(this.getGender() == 'F') {
			child.setMother(null);
		}
		else {
			child.setFather(null);
		}
		
	}
	
	public void setMother(Person newMother) {
		if(newMother!=null && newMother.getGender() != 'F') {
			throw new IllegalArgumentException("Mother must be female");
		}
		if(isSelf(newMother)) {
			throw new IllegalArgumentException("you can't be your own mother");
		}
		if(this.getMother() == newMother) {
			return;
		}
		//if prevMother is null we don't need to update further
		Person prevMother = this.getMother();
		this.mother = newMother;
		if((prevMother!= null) && (prevMother.children.contains(this))){
			prevMother.removeChild(this);
		}
		if(newMother != null) {
			newMother.addChild(this);
		}
		
	}
	
	public void setFather(Person newFather) {
		if(newFather != null && newFather.getGender() != 'M') {
			throw new IllegalArgumentException("Father must be male");
		}
		if(isSelf(newFather)) {
			throw new IllegalArgumentException(
					"you can't be your own father");
		}
		if(this.getFather() == newFather) {
			return;
		}
		//if prevFather is null we don't need to update further
		Person prevFather = this.getFather();
		this.father = newFather;
		if((prevFather!= null) && (prevFather.children.contains(this))){
			prevFather.removeChild(this);
		}
		if(newFather != null) {
			newFather.addChild(this);
		}
	}
	
	private boolean isSelf(Person person) {
		if(this == person) {
			return true;
		}
		return false;
	}
	
	

	public static void main(String[] args) {
//		Person p1 = new Person("Alex",'M');
//		Person p2 = new Person("Nils",'M');
//		Person p3 = new Person("Turid",'F');
//		Person p4 = new Person("Hedda",'F');

	}

}
