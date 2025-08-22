package threads;

import java.util.Scanner;
public class thread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Addition started");
		System.out.println("enter the first number :");
		int n1=scanner.nextInt();
		System.out.println("enter the second number :");
		int n2=scanner.nextInt();
		int res=n1+n2;
		System.out.println("result :"+res);
		System.out.println("Addition finished");
		
		System.out.println("printing started");
		for(int i=0;i<=10;i++) {
			System.out.println("orewa mugiwara no luffy");
		}
		System.out.println("printing finished");
		
		System.out.println("banking started");
		System.out.println("enter the bank account");
		int acc=scanner.nextInt();
		
		System.out.println("enter the name");
		String name=scanner.nextLine();
		System.out.println("account number"+acc);
		System.out.println("name :"+name);
		System.out.println("banking over");
		scanner.close();
	}

}
