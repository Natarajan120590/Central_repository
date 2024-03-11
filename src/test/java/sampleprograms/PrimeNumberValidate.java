package sampleprograms;

import java.util.Scanner;

public class PrimeNumberValidate {

	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		sc.close();
		int count=0;
		for(int i=2;i<num;i++)
		{
			if(num%i==0)
			{
				count=count+1;
			}
		}
		System.out.println("Count is: "+count);
		if(count==0)
		{
			System.out.println("given number is prime number");
		}
		else
		{
			System.out.println("given number is not prime number");
		}

	}

}
