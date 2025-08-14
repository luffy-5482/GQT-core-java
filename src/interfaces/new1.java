package interfaces;

import java.util.Scanner;

abstract class Shapes {
	double area;
	abstract void collect();
	abstract void calculate();
	void display() {
		System.out.println("The area calculate is :" +area);
	}
	
}
class Circle extends Shapes {
	private double r;
	private final double pi = 3.1476;
	@Override
	void collect() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius :");
		r = sc.nextDouble();
	}
	@Override
	void calculate() {
		area = pi * r *r;
	}
}
class Rectangle extends Shapes {
	private double l, b;
	@Override
	void collect() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length :");
		l = sc.nextDouble();
		System.out.println("Enter the breadth :");
		b = sc.nextDouble();	
		}
		@Override
		void calculate() {
			area = l * b;
		}
		}
		class Square extends Shapes {
			private double side;
			@Override
			void collect() {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the side :");
				side = sc.nextDouble();
				}
				@Override
				void calculate() {
					area = side * side;
				}
		}

class Geometry {
	void useShapes(Shapes s) {
		s.collect();
		s.calculate();
		s.display();
	}
}

public class new1 {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Circle c = new Circle();
    	Rectangle r = new Rectangle();
    	Square s = new Square();
    	Geometry g = new Geometry();
    	
    	g.useShapes(c);
    	System.out.println("-----------");
    	g.useShapes(r);
    	System.out.println("-----------");
    	g.useShapes(s);
    	System.out.println("-----------");

	}

}