package sampleprograms;

import java.util.Scanner;

public class PrimeNumbers1to100 {

	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		sc.close();
		System.out.println("Prime numbers are:");
		for(int i=1;i<=num;i++)
		{
			int count=0;
			for(int j=1;j<=num;j++)
			{
				if(i%j==0)
				{
					count=count+1;
				}
			}
		     if(count==2)
		     {
		    	 System.out.print(i+" ");
		     }
		}
	}

}
