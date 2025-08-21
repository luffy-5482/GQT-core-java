package ExceptionHandling;
import java.util.Scanner;

class Operations1{
	void function1() throws Exception {
		System.out.println("Inside function-2");
			Scanner sc = new Scanner(System.in);
			// TODO Auto-generated method stub
			System.out.println("Division Operation");	
			System.out.println("Enter the first number :");
			int n1 = sc.nextInt();// critical statement -- InputMismatchException
			System.out.println("Enter the second number :");
			int n2 = sc.nextInt();// critical statement -- InputMismatchException
			
			int res = n1 / n2;//critical statement -- ArithmeticException
			System.out.println(res);
	}
}
class Operations2 {
	void function2() throws Exception {
		System.out.println("Inside function-2");
		Operations1 op1 = new Operations1();
		op1.function1();
		System.out.println("Outoff function-2");
	}
}
class Operations3 {
	void function3() {
		System.out.println("Inside function-3");
		Operations2 op2 = new Operations2();
		try {
		op2.function2();
		} catch (Exception e) {
		System.out.println("Outoff function-3");
	}
		System.out.println("Outoff function");
}
	public class example {
		public static void main(String[] args) {
			System.out.println("Inside, main function");
			Operations3 op3 = new Operations3();
			op3.function3();
			System.out.println("outoff main function");
		}
	}
}