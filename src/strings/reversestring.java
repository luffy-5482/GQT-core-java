package strings;

import java.util.Scanner;

public class reversestring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the string ");
		String string=scanner.nextLine();
		String res="";
		for(int i=string.length()-1;i>=0;i--) {
			res=res+string.charAt(i);
		}
		System.out.println("the reversed string is :-"+res);
		scanner.close();
	}

}
