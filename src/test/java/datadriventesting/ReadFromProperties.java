package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {

	public static void main(String[] args) throws IOException 
	{
		// step1: convert physical file into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
		
		//step2: Create an instance for Properties class
		Properties property= new Properties();
		
		//step3: Load all key-value pairs to properties object from fis
		property.load(fis); 
		
		//step4: Fetch data from Properties using key
		System.out.println(property.getProperty("url"));
		System.out.println(property.getProperty("browser"));
		System.out.println(property.getProperty("time"));
		

	}

}
