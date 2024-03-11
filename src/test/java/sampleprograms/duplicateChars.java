package sampleprograms;

import java.util.ArrayList;

public class duplicateChars {

	public static void main(String[] args) {
		
		String str="Hello Natarajan bhanu";
		String str2="";
		char ch,ch2;
		ArrayList<Character> chrs=new ArrayList<Character>();
		for(int i=0;i<str.length();i++)
		{
			int count=0;
			ch=str.toLowerCase().charAt(i);				
			for(int j=i+1;j<str.length();j++)
			{
				
				if(ch==str.toLowerCase().charAt(j))
				{
					count=count+1;						
				}
				
			}
					
			if(count==0)
			{
				str2=str2+ch;	
				chrs.add(ch);
			}
			
		}
		System.out.println("STR2 is===>"+str2);
		
		for(int i=0;i<str.length();i++)
		{
			int count=0;
			ch2=str.toLowerCase().charAt(i);		
			for(int j=i;j<str.length();j++)
			{
				
				if(ch2==str.toLowerCase().charAt(j))
				{
					count=count+1;						
				}
				
			}
			if(count>1)
			{
				int size=chrs.size();
				for(int k=0;k<size;k++)	
				{
					if(chrs.size()!=0)
					{
					 if(ch2==chrs.get(k))
					 {
						
								System.out.println("Duplicate charactor is: "+ch2+" ===>"+count);	
								chrs.remove(k);
								size=size-1;
								break;
						
					 }
					}
				}
			}
			
		}
	}

}
