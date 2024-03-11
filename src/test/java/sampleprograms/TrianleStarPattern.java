package sampleprograms;

import java.util.Scanner;

public class TrianleStarPattern {

	public static void main(String[] args) {
		System.out.println("Enter the no-of rows:");
		Scanner sc=new Scanner(System.in);
		int rows=sc.nextInt();
		
		for(int i=1;i<=rows;i++)
		{
			for(int j=rows;j>=i;j--)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++)
			{
				System.out.print(k+" ");
			}
			System.out.println();
		}

	}

}
