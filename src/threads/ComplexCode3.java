package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Cricketer2 {
	String name;
	int runs;
	int matches;
	int wickets;
	int catches;
	public Cricketer2(String name, int runs, int matches, int wickets, int catches) {
		super();
		this.name = name;
		this.runs = runs;
		this.matches = matches;
		this.wickets = wickets;
		this.catches = catches;
	}
	
	@Override
	public String toString() {
		return name+"---"+runs+"---"+matches+"---"+wickets+"---"+catches;
	}

	
}

class Support implements Comparator<Cricketer2>{
	@Override
	public int compare(Cricketer2 x,Cricketer2 y) {
		if(x.runs > y.runs) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
public class ComplexCode3 {
	public static void main(String[] args) {
		Cricketer2 c1 = new Cricketer2("Rohith", 13000, 200, 50, 300);
		Cricketer2 c2 = new Cricketer2("Smith", 14000, 250, 20, 178);
		Cricketer2 c3 = new Cricketer2("ABD", 9560, 176, 30, 376);
		
		ArrayList<Cricketer2> al = new ArrayList<Cricketer2>();
		al.add(c1);
		al.add(c2);
		al.add(c3);
		System.out.println(al);
		Support support = new Support();
		Collections.sort(al,support);
		System.out.println(al);
	}
}
