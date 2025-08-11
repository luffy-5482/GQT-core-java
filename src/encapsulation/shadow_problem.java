package encapsulation;

import java.util.Scanner;

class dog{
private String name;
private String color;
private String breed;
private int age;
private int cost;
void setdata(String name,String color,String breed,int age,int cost) {
	name=name;
	color=color;
	breed = breed ;
	age=age;
	cost=cost;
	}
	void getdata() {
		System.out.println("name = "+name);
		System.out.println("color = "+color);
		System.out.println("breed = "+breed );
		System.out.println("age = "+age);
		System.out.println("cost = "+cost);
	}
}
	public class shadow_problem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dog d=new dog();
		Scanner sc=new Scanner(System.in);
		System.out.print("enter the name of the dog : ");
		String name=sc.nextLine();
		System.out.print("enter the color of the dog : ");
		String color=sc.nextLine();
		System.out.print("enter the breed of the dog : ");
		String breed=sc.nextLine();
		System.out.print("enter the age of the dog : ");
		int age=sc.nextInt();
		System.out.print("enter the cost of the dog : ");
		int cost=sc.nextInt();
		d.setdata(name,color,breed,age,cost);
		d.getdata();
		sc.close();
	}

}
