package threads;

import java.util.Scanner;

class operation1 extends Thread{
	
	public void run() {
		try {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Addition started");
		System.out.println("enter the first number :");
		int n1=scanner.nextInt();
		System.out.println("enter the second number :");
		int n2=scanner.nextInt();
		int res=n1+n2;
		System.out.println("result :"+res);
		System.out.println("Addition finished");
		}
		catch (Exception e){
			System.out.println(e.getStackTrace());
	}
	}
}
class operation2 extends Thread{
	public void run() {
		System.out.println("printing started");
		for(int i=0;i<=10;i++) {
			System.out.println("orewa mugiwara no luffy");
		}
		System.out.println("printing finished");
		}
	}

class operation3 extends Thread{
	public void run() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("banking started");
		System.out.println("enter the bank account");
		int acc=scanner.nextInt();
		
		System.out.println("enter the name");
		String name=scanner.nextLine();
		System.out.println("account number"+acc);
		System.out.println("name :"+name);
		System.out.println("banking over");
	}
}
public class thread4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		operation1 o1=new operation1();
		operation2 operation2=new operation2();
		operation3 operation3=new operation3();
		o1.start();
		operation2.start();
		operation3.start();
	}

}
