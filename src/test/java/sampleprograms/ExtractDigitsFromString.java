package sampleprograms;

import java.util.ArrayList;
import java.util.Scanner;

public class ExtractDigitsFromString {

	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();		
		//String str="hello 123 natar548ajan 546 nimma 3";
		sc.close();
		char ch;		
		String str2 = "";
		ArrayList<Integer> arr=new ArrayList<Integer>();
	    for(int i=0;i<str.length();i++)
	    {
	    	ch=str.charAt(i);
	    	if(Character.isSpace(ch))
	    	{
	    		if(!(str2.isEmpty()))
		    	{
		    			arr.add(Integer.valueOf(str2));
		    			str2="";
		    			
		    	}    		
	    		
	    	}
	    	else if(Character.isLetter(ch))
	    	{
	    		if(!(str2.isEmpty()))
		    	{
		    			arr.add(Integer.valueOf(str2));
		    			str2="";
		    			
		    	}    	
	    	}
	    	else if(Character.isDigit(ch))
	    	{
	    		
	    		str2=str2+ch;
	    		if(i==str.length()-1)
	    		{
		    		if(!(str2.isEmpty()))
		    		{
		    			arr.add(Integer.valueOf(str2));
		    			str2="";
		    			
		    		}
	    		}
	    	}
	    	
	    }
	    System.out.println("numbers are: "+arr);
	
	}

}
