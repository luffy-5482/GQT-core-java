package polymorphism;

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
	void rabbittype() {
		System.out.println("rabbit is herbivore");
	}
}
class Lion extends Animal1{
	@Override
	void eat() {
		System.out.println("Lion eat Meat");
	}
	void liontype() {
		System.out.println("lion is carnivore");
	}
}
class Deer extends Animal1{
	@Override
	void eat() {
		System.out.println("Deer eat Grass");
	}
	void deertype() {
		System.out.println("deer is herbivore");
	}
}
public class example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rabbit r=new Rabbit();
		Lion l=new Lion();
		Deer d=new Deer();
		
		Animal1 ref;
		ref =r;
		ref.eat();
		ref.breath();
		ref.sleep();
		r.rabbittype();
		System.out.println("--------------");
		
		ref=l;
		ref.eat();
		ref.breath();
		ref.sleep();
		l.liontype();
		System.out.println("--------------");
		
		ref=d;
		ref.eat();
		ref.breath();
		ref.sleep();
		d.deertype();
	}
	
}
