package sampleprograms;

import java.util.Scanner;

public class RemoveDuplicateChars {

	public static void main(String[] args) {
		System.out.println("Enter the String:");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		//String str="hello natarajan";
		char[] charArr=str.toCharArray();
		
		
		String str2="";
		char ch;
		for(int i=0;i<charArr.length;i++)
		{
			ch=charArr[i];
			int count=0;
			for(int j=i+1;j<charArr.length;j++)
			{
				if(ch==charArr[j])
				{
					count=count+1;
					
				}
			}
			if(count==0)
			{
				str2=str2+ch;
			}
		}
		System.out.println("After Remove Duplicate chars=>"+str2);

	}

}
