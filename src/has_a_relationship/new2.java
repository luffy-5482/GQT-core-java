package has_a_relationship;

class Brain{
	double weight;
	int iq;
	public Brain(double weight, int iq) {
		super();
		this.weight = weight;
		this.iq = iq;
	}
	public double getWeight() {
		return weight;
	}
	public int getIq() {
		return iq;
	}
}
class Heart{
	double size;
	int valves;
	public Heart(double size, int valves) {
		super();
		this.size = size;
		this.valves = valves;
	}
	public double getSize() {
		return size;
	}
	public int getValves() {
		return valves;
	}
	
}
class Human{
	Brain bn=new Brain(25,6);
	Heart h=new Heart(35,4);
}
class Book{
	String name;
	int cost;
	public Book(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public int getCost() {
		return cost;
	}
}
class Mobile1{
	String company;
	String model;
	public Mobile1(String company, String model) {
		super();
		this.company = company;
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public String getModel() {
		return model;
	}
	
}
class Student extends Human{
	void hasBook(Book b) {
		System.out.println(b.getName());
		System.out.println(b.getCost());
	}
	void hasMobile1(Mobile1 m) {
			System.out.println(m.getCompany());
			System.out.println(m.getModel());
		}
}
public class new2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Student s=new Student ();
 Book bk=new Book("Unforgettable Love",160);
 Mobile1 m=new Mobile1("Apple","iphone");
 System.out.println(s.bn.getWeight());
 System.out.println(s.bn.getIq());
 System.out.println("--------------");
 System.out.println(s.h.getSize());
 System.out.println(s.h.getValves());
 System.out.println("----------------");
 s.hasBook(bk);
 s.hasMobile1(m);
	}

}