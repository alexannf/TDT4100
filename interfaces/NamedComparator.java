package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NamedComparator implements Comparator<Named>{

	
	@Override
	public int compare(Named named1, Named named2) {
		int diff = named1.getFamilyName().compareTo(named2.getFamilyName());
		if (diff == 0) {
			diff = named1.getGivenName().compareTo(named2.getGivenName());
		}
		return diff;
	}
	
	public static void main(String[] args) {
		Person2 a = new Person2("Rolf Bjerknes");
		Person2 b = new Person2("John Snow");
		Person2 c = new Person2("Cersei Lannister");
		Person2 d = new Person2("Tyrion Lannister");
		Person2 e = new Person2("Jamie Lannister");
		Person2 f = new Person2("Alf Bjerknes");
		Person2 g = new Person2("Aegon Targaryen");
		Person2 h = new Person2("Daenerys Targaryen");
		Person2 i = new Person2("Rudolf Bjerknes");
		
		List<Named> nameList = new ArrayList<Named>();
		nameList.add(a);
		nameList.add(b);
		nameList.add(c);
		nameList.add(d);
		nameList.add(e);
		nameList.add(f);
		nameList.add(g);
		nameList.add(h);
		nameList.add(i);
		
		System.out.println(nameList);
		Collections.sort(nameList, new NamedComparator());
		System.out.println(nameList);

	}

}
