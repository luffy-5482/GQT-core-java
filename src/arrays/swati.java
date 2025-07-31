package arrays;

import java.util.Scanner;

class educational_trust{
	 	int trust[][][];
	    String names[][][];
	    String colleges[] = {"medical", "engineering", "degree"};
	    long tot_rev=0;
	    int med=2500000;
	    int eng=250000;
	    int deg=80000;
	    Scanner scanner = new Scanner(System.in);

	    void create() {
	        System.out.println("Enter the number of colleges:");
	        int clg_count = scanner.nextInt();
	        trust = new int[clg_count][][];
	        names = new String[clg_count][][];
	        for (int i = 0; i < clg_count; i++) {
	            System.out.print("Enter the number of classrooms in " + colleges[i] + " college: ");
	            int cls_count = scanner.nextInt();

	            trust[i] = new int[cls_count][];
	            names[i] = new String[cls_count][];

	            for (int j = 0; j < cls_count; j++) {
	                System.out.print("Enter the number of students in classroom " + (j + 1) + ": ");
	                int student_count = scanner.nextInt();
	                

	                trust[i][j] = new int[student_count];
	                names[i][j] = new String[student_count];
	                for (int k = 0; k < student_count; k++) {
	                    System.out.print("Enter name of student " + (k + 1) + " in classroom " + (j + 1) + ": ");
	                    names[i][j][k] = scanner.next();
	                    trust[i][j][k] = 1;
	                }
	            }
	        }
	    }
		
	void display() {
	
		    for (int i = 0; i < names.length; i++) {
		        System.out.println("\nCollege: " + colleges[i]);

		        for (int j = 0; j < names[i].length; j++) {
		            System.out.println("  Classroom " + (j + 1) + ":");

		            for (int k = 0; k < names[i][j].length; k++) {
		                System.out.println("    Student " + (k + 1) + ": " + names[i][j][k]);
		            }
		        }
		    }
	}
		    void revenue() {
		        System.out.println("\n---- College-wise Revenue Report ----");
		        for (int i = 0; i < trust.length; i++) {
		            int student_count = 0;

		            for (int j = 0; j < trust[i].length; j++) {
		                student_count += trust[i][j].length;
		            }

		            long college_rev = 0;
		            if (i == 0) {
		                college_rev = student_count * med;
		            } else if (i == 1) {
		                college_rev = student_count * eng;
		            } else if (i == 2) {
		                college_rev = student_count * deg;
		            }

		            tot_rev += college_rev;

		            System.out.println(colleges[i] + " college revenue: ₹" + college_rev);
		        }
		        System.out.println("Total revenue from all colleges: ₹" + tot_rev);
		    }
	}


public class swati {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		educational_trust eTrust=new educational_trust();
		eTrust.create();
		eTrust.display();
		eTrust.revenue();
	}

}
