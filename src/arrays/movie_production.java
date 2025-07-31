package arrays;

import java.util.Scanner;

class movie{
	Scanner scanner = new Scanner(System.in);
    String[] languages = {"Kannada", "Hindi", "Tamil"};
    int[][] revenue = new int[3][3];
    int[] totalPerMovie = new int[3];
    int totalRevenue = 0;
    int totalInvestment = 100;
    int previousYearProfit = 80;
    
    void collectdata() {
    	System.out.println("----- Eclipse Productions Financial Report (FY 2024–25) -----\n");
    	for (int i = 0; i < 3; i++) {
            System.out.println("Enter revenue for Movie " + (i + 1));
            for (int j = 0; j < 3; j++) {
                System.out.print("  " + languages[j] + ": ₹");
                revenue[i][j] = scanner.nextInt();
                totalPerMovie[i] += revenue[i][j];
            }
            System.out.println();
            totalRevenue += totalPerMovie[i];
        }
    }
    void display() {
    	System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < 3; i++) {
            System.out.println("Movie " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                System.out.println("   " + languages[j] + ": ₹" + revenue[i][j] + " Cr");
            }
            System.out.println("   Total Revenue: ₹" + totalPerMovie[i] + " Cr\n");
        }

        int profit = totalRevenue - totalInvestment;
        System.out.println("-------------------------------------------------------------");
        System.out.println("Total Investment: ₹" + totalInvestment + " Cr");
        System.out.println("Total Revenue: ₹" + totalRevenue + " Cr");
        System.out.println("Total Profit: ₹" + profit + " Cr");

        if (profit > 0) {
            System.out.println("Status: Profitable");
        } else {
            System.out.println("Status: Loss Incurred");
        }

        System.out.println("\nComparison with Previous Year (₹" + previousYearProfit + " Cr profit):");
        if (profit > previousYearProfit) {
            System.out.println("More profitable than previous year by ₹" + (profit - previousYearProfit) + " Cr");
        } else if (profit < previousYearProfit) {
            System.out.println(" Profit is less than previous year by ₹" + (previousYearProfit - profit) + " Cr");
        } else {
            System.out.println("  Same profit as last year.");
        }
        
        System.out.println("-------------------------------------------------------------");
    }
}
public class movie_production {

    public static void main(String[] args) {
       movie m=new movie();
       m.collectdata();
       m.display();
    }
}
