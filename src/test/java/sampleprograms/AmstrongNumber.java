package sampleprograms;

import java.util.Scanner;

public class AmstrongNumber {

	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		sc.close();
		//int num=153;
		int temp=num;
		int sum = 0;
		int count=0,remainder;		
		while(num>0)
		{		
			count=count+1;
			num=num/10;
		}
		System.out.println("Count is: "+count);
		num=temp;
		while(num>0)
		{
			remainder=num%10;
			 sum += (Math.pow(remainder, count));
			num=num/10;
		}
        System.out.println("Sum of value is: "+sum);
		if(temp==sum)
		{
		  System.out.println("Given number is Amstrong");
		}
		else
		{
			System.out.println("Given number is not Amstrong");
		}
	}

}
