package strings;

import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the string ");
		String string=scanner.nextLine();
		String res="";
		for(int i=string.length()-1;i>=0;i--) {
			res=res+string.charAt(i);
		}
		if(string.equals(res)==true)
			System.out.println("palindrome");
		else 
			System.out.println("not a palindrome");
	}

}
