package encapsulation;
class lion {
	private String name;
	private String color;
	private String country;
	private int age;
	
	void setdata1() {
		name="Kiran";
		color="yellow";
		country="afrca";
		age=9;
	}
	void setdata2(String a,String b, String c, int d) {
		name=a;
		color=b;
		country=c;
		age=d;
	}
	void getdata() {
		System.out.println("name = "+name);
		System.out.println("color = "+ color);
		System.out.println("country = "+country);
		System.out.println("age = "+age);
	}
}
public class example1 {
public static void main(String[] args) {
	lion lion= new lion();
	lion.setdata1();//you can only access the elements like this if it is declared as the private variable 
	lion.getdata();
	System.out.println("--------------------------");
	lion.setdata2("Ramu", "brown", "India", 14);
	lion.getdata();
}
}
