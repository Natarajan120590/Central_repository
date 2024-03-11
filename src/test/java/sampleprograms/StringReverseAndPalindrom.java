package sampleprograms;

import org.testng.annotations.Test;

import helpers.TestBase;

public class StringReverseAndPalindrom extends TestBase{

	@Test
	public void StringReverPalindrom()
	{
		   String str="NATAN";
	       String str2="";
	       int size=str.length();
	       for(int i=size-1;i>=0;i--)
	       {
	           str2=str2+str.charAt(i);
	       }
	       if(str.equals(str2))
	       {
	           System.out.println("Given String is polindrom");
	       }
	       else
	       {
	           System.out.println("Given String is not polindrom");
	       }

	}

}
