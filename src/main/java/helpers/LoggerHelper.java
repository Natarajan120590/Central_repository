package helpers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LoggerHelper 
{
	public static Logger getLogger(Class<?> cls)
	{
		boolean root=false;
		
		if(root)
		{
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure("C:\\Users\\natar\\eclipse-workspace\\SCB_WorkBench\\src\\main\\resources\\Log4j.properties");
		root=true;
		return Logger.getLogger(cls);
	}

}
