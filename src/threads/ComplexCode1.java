package threads;

import java.util.ArrayList;
import java.util.Collections;

import has_a_relationship.new1;

class Cricketer{
	String name;
	int runs;
	int matches;
	int wickets;
	int catches;
	public Cricketer(String name, int runs, int matches, int wickets, int catches) {
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
public class ComplexCode1 {
	public static void main(String[] args) {
		Cricketer c1 = new Cricketer("Rohith", 13000, 200, 50, 300);
		Cricketer c2 = new Cricketer("Smith", 14000, 250, 20, 178);
		Cricketer c3 = new Cricketer("ABD", 9560, 176, 30, 376);
		
		ArrayList<Cricketer> al = new ArrayList<Cricketer>();
		al.add(c1);
		al.add(c2);
		al.add(c3);
		System.out.println(al);
		Collections.sort(al);
	}
}
