package strings;

import java.util.Scanner;

public class sumandproduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the string :");
		String str=scanner.nextLine();
		int sum=0;
		int product=1;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
				continue;
			if(str.charAt(i)=='A' ||str.charAt(i)=='E'||str.charAt(i)=='I' ||str.charAt(i)=='O'||str.charAt(i)=='U') {
				sum+=str.charAt(i);
			}
			else {
				product*=str.charAt(i);
			}
		}
		System.out.println("the sum of all the capital vowels are :"+sum);
		System.out.println("the product of all the consonants are :"+product);
		scanner.close();
	}

}
