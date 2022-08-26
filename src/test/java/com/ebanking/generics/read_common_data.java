package com.ebanking.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class read_common_data extends BaseClass
{
//public static String getpropertydata(String key) throws IOException
//{
//	 fis=new FileInputStream("src/test/resources/testdata/commondata.properties");
//	 prop=new Properties();
//	prop.load(fis);
//	String data=prop.getProperty(key);
//	return data;
//}
	public read_common_data()
	{
		try {
			fis=new FileInputStream("src/test/resources/testdata/commondata.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getApplicationURL()
	{
		String url=prop.getProperty("URL");
		
		return url;
	}
	public static String getUserID()
	{
		return prop.getProperty("UserID");
	}
	public static String getPassword()
	{
		return prop.getProperty("Password");
	}
	public static String getChromepath()
	{
		return prop.getProperty("chromepath");
	}
	public static String getIEpath()
	{
		return prop.getProperty("iepath");
	}
	public static String getFirefoxpath()
	{
		return prop.getProperty("firefoxpath");
	}
	public static String getEdgepath()
	{
		return prop.getProperty("edgepath");
	}
}
