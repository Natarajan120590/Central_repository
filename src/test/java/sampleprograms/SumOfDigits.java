package sampleprograms;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		sc.close();
		int remainder=0,sum=0;
		while(num!=0)
		{
			remainder=num%10;
			sum=sum+remainder;
			num=num/10;
			
		}
		System.out.println("Sum of digits is: "+sum);
	}

}
