package ExceptionHandling;

import java.util.Scanner;
class UnderAgeException extends Exception{
	public String getmessage() {
		return "the age is less than the minimum age. Application cannot be processed";
	}
}
class OverAgeException extends Exception{
	public String getmessage() {
		return "the age is more than the maximum age. Application cannot be processed";
	}
}
class candidate{
	int age;
	void CollectData() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the age :");
		age=scanner.nextInt();
	}
	void validate() throws UnderAgeException,OverAgeException {
		if(age<18) {
			UnderAgeException uae=new UnderAgeException();
			System.out.println(uae.getmessage());
			throw uae;
		}
		if(age>60) {
			OverAgeException oae=new OverAgeException();
			System.out.println(oae.getmessage());
			throw oae;
		}
	}
}
class Matrimony{
	void process(candidate c) {
			try {
				c.CollectData();
				c.validate();
			}
			catch (UnderAgeException | OverAgeException e1){
				try {
					c.CollectData();
					c.validate();
				}
				catch (UnderAgeException | OverAgeException e2){
					try {
						c.CollectData();
						c.validate();
					}
					catch (UnderAgeException | OverAgeException e3){
						System.out.println("Candidate is blocked");
						System.exit(0);
					}
				}
			}
	}
}
public class example7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrimony m=new Matrimony();
		candidate c = new candidate();
		m.process(c);
	}

}
