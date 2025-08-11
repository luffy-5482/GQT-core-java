package constructors;
class Dog{
	private String name;
	private String color;
	private String breed;
	private int age;
	private int cost;
	
	// zero parameterized constructor
	public Dog()
	{
		super();
		System.out.println("inside zero parameterized constructor");
		this.name="ramu";
		this.color="brown";
		this.breed="husky";
		this.age=6;
		this.cost=6000;
		System.out.println(this.name);
		System.out.println(this.color);
		System.out.println(this.cost);
		System.out.println(this.age);
		System.out.println(this.breed);
		System.out.println("--------");
		
}
	// one parameterized constructor
	public Dog(String name)
	{
		this();
		System.out.println("inside one parameterized constructor");
		this.name=name;
		System.out.println(this.name);
		System.out.println(this.color);
		System.out.println(this.cost);
		System.out.println(this.age);
		System.out.println(this.breed);
		System.out.println("--------");
		
}
	// two parameterized constructor
		public Dog(String name,String color)
		{
			this("sony");
			System.out.println("inside two parameterized constructor");
			this.name=name;
			this.color=color;
			System.out.println(this.name);
			System.out.println(this.color);
			System.out.println(this.cost);
			System.out.println(this.age);
			System.out.println(this.breed);
			System.out.println("--------");
			
	}
		// three parameterized constructor
				public Dog(String name,String color,String breed)
				{
					this("charle","black");
					System.out.println("inside three parameterized constructor");
					this.name=name;
					this.color=color;
					this.breed=breed;
					System.out.println(this.name);
					System.out.println(this.color);
					System.out.println(this.cost);
					System.out.println(this.age);
					System.out.println(this.breed);
					System.out.println("--------");
					
			}
				// four parameterized constructor
				public Dog(String name,String color,String breed,int age)
				{
					this("bunny","purple","gr");
					System.out.println("inside four parameterized constructor");
					this.name=name;
					this.color=color;
					this.breed=breed;
					this.age=age;
					System.out.println(this.name);
					System.out.println(this.color);
					System.out.println(this.cost);
					System.out.println(this.age);
					System.out.println(this.breed);
					System.out.println("--------");
					
			}
				// five parameterized constructor
				public Dog(String name,String color,String breed,int age,int cost)
				{
					this("raja","orange","husky",6);
					System.out.println("inside five parameterized constructor");
					this.name=name;
					this.color=color;
					this.breed=breed;
					this.age=age;
					this.cost=cost;
					System.out.println(this.name);
					System.out.println(this.color);
					System.out.println(this.cost);
					System.out.println(this.age);
					System.out.println(this.breed);
					System.out.println("--------");
			}
}
				
				
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d2=new Dog("rocky","white","husky",8,9000);
	}
}