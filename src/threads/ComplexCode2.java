package threads;

import java.util.ArrayList;
import java.util.Collections;


class Cricketer1 implements Comparable<Cricketer1>{
	String name;
	int runs;
	int matches;
	int wickets;
	int catches;
	public Cricketer1(String name, int runs, int matches, int wickets, int catches) {
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

	@Override
	public int compareTo(Cricketer1 x) {
		if(this.runs > x.runs) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
public class ComplexCode2 {
	public static void main(String[] args) {
		Cricketer1 c1 = new Cricketer1("Rohith", 13000, 200, 50, 300);
		Cricketer1 c2 = new Cricketer1("Smith", 14000, 250, 20, 178);
		Cricketer1 c3 = new Cricketer1("ABD", 9560, 176, 30, 376);
		
		ArrayList<Cricketer1> al = new ArrayList<Cricketer1>();
		al.add(c1);
		al.add(c2);
		al.add(c3);
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);
	}
}
