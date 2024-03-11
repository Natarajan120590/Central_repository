package sampleprograms;

import java.util.Scanner;

public class IntegerPalindrom {

	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner sc=new Scanner(System.in);		
		int num=sc.nextInt();
		sc.close();
		int temp=num;
		int remainder=0,reverseNum=0;
		while(num!=0)
		{
			remainder=num%10;
			reverseNum=reverseNum*10+remainder;
			num=num/10;
			
		}
		System.out.println("Reverse number is:"+reverseNum);
		if(temp==reverseNum)
		{
			System.out.println("Given number is palindrom");
		}
		else
		{
			System.out.println("Given number is not palindrom");
		}
	}

}
