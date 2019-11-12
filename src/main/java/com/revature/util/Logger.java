package com.revature.util;

public class Logger {
	private static Logger logger =null;
	public static Logger getInstance()
	{
	    if(logger==null)
	    {
	        logger=new Logger();
	    }
	    return logger;
	}
	static String level="INFO";
	public void info(Object message)
	{
	    if(level.equals("INFO"))
	    {
	        System.out.println(message);
	    }
	}
	public static void debug(Object message)
	{
	    if(level.equals("DEBUG"))
	    {
	        System.out.println(message);
	    }
	}
	public static void error(Object message)
	{
	    if(level.equals("ERROR"))
	    {
	        System.out.println(message);
	    }
	}
	public void error(Exception e) {
		if( level.equals("ERROR") )
			System.out.println(e);
	}

}
