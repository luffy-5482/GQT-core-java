package arrays;

import java.util.Scanner;

class mulmatrix{
	int mat1[][]=new int[2][2];
	int mat2[][]=new int[2][2];
	int added[][]=new int[2][2];
	Scanner scanner=new Scanner(System.in);
	void create() {
		System.out.println("enter the elements of the matrix 1");
		for(int i=0;i<2;i++)
		{
			System.out.println();
				for(int j=0;j<2;j++) {
					mat1[i][j]=scanner.nextInt();
							}
		}
		System.out.println("enter the elements of the matrix 2");
		for(int i=0;i<2;i++)
		{
			System.out.println();
				for(int j=0;j<2;j++) {
					mat2[i][j]=scanner.nextInt();
				}
		}
	}
	void mul() {
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				added[i][j]=mat1[i][j]*mat2[i][j];
			}
		}
	}
	void display() {
		System.out.println("the multiplied matrix is :");
		for(int i=0;i<2;i++)
		{
			System.out.println();
			for(int j=0;j<2;j++)
			{
				System.out.print(added[i][j]+" ");
			}
		}
	}
}
public class matrixmultiplication {

	public static void main(String[] args) {
		mulmatrix mat=new mulmatrix();
		mat.create();
		mat.mul();
		mat.display();
	}

}
