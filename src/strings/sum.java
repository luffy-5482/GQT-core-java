package strings;

import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the string :");
		String string=scanner.nextLine();
		int sum=0;
		for(int i=0;i<string.length();i++) {
			sum+=string.charAt(i);
		}
		System.out.println("the sum of the given string is :"+sum);
		scanner.close();
	}

}
