package strings;

import java.util.Scanner;

public class reversestringwordwise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the string : ");
		String string=scanner.nextLine();
		
		//step:1 - Counting spaces
		int spc_count=0;
		for(int i=0;i<string.length();i++) {
			if(string.charAt(i)==' ') {
				spc_count++;
			}
		}
		//step2: first word count 
		int word_count=spc_count+1;
		
		//step3: create array based on word count 
	}

}
