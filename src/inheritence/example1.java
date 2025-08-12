package inheritence;
class animal{
	public animal(){
		super();
		System.out.println("animal zero parameterized constructor is invoked ");
	}
	 public animal(String message) {
		 System.out.println("animal parameterized constructor is invoked");
		 System.out.println("the animal constructor has recieved the message as :"+message);
	 }
}
class elephant extends animal {
	String name;
	double weight;
	public elephant() {
		super("hello from elephant");
		System.out.println("hi from elephant constructor");
	}
	public elephant(String name,double weight ) {
		super();
		this.name=name;
		this.weight=weight;
		System.out.println(this.name);
		System.out.println(this.weight);
	}
}
public class example1 {
	public static void main(String[] args) {
		elephant elephant=new elephant();
		System.out.println("---------------------");
		elephant elephant2=new elephant("Arjuna",5000.26);
		
	}
}
