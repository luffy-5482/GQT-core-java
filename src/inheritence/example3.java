package inheritence;
class Animal1{
	void eat() {
		System.out.println("Animal is Eating");
	}
	void sleep() {
		System.out.println("Animal is Sleeping ");
	}
	void breath() {
		System.out.println("Animal takes air as breath");
	}
}
class Rabbit extends Animal1{
	@Override
	void eat() {
		System.out.println("Rabbit eat Carrot");
	}
}
class Lion extends Animal1{
	@Override
	void eat() {
		System.out.println("Lion eat Meat");
	}
}
class Deer extends Animal1{
	@Override
	void eat() {
		System.out.println("Deer eat Grass");
	}
}
public class example3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rabbit r=new Rabbit();
		Lion l=new Lion();
		Deer d=new Deer();
		r.eat();
		r.breath();
		r.sleep();
		System.out.println("--------------");
		l.eat();
		l.breath();
		l.sleep();
		System.out.println("--------------");
		d.eat();
		d.breath();
	}
	
}
