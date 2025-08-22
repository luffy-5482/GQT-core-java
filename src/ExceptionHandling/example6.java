package ExceptionHandling;
import java.util.Scanner;

class Operations11{
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
			sc.close();
	}
}
class Operations22 {
	void function2() throws Exception {
		System.out.println("Inside function-2");
		Operations11 op1 = new Operations11();
		op1.function1();
		System.out.println("Outoff function-2");
	}
}
class Operations33 {
	void function3() throws Exception{
		System.out.println("Inside function-3");
		Operations22 op2 = new Operations22();
		try {
		op2.function2();
		} catch (Exception e) {
		System.out.println("Outoff function-3");
		throw e;
	}  
		System.out.println("Outoff function");
}
	public class example6 {
		public static void main(String[] args) {
			System.out.println("Inside, main function");
			Operations33 op3 = new Operations33();
			try {
				op3.function3();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Exception handled in the main function");
			}
			System.out.println("outoff main function");
			
		}
	}
}