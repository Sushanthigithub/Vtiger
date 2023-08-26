package datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataToProperties {

	public static void main(String[] args) throws IOException 
	{
		// step1: convert physical file into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
				
		//step2: Create an instance for Properties class
		Properties property= new Properties();
				
		//step3: Load all key-value pairs to properties object from fis
		property.load(fis); 
		
		//step4: Write data into properties
		property.put("username2", "trainee");
		property.put("password2", "trainee");
		
		//step5: Save properties
		FileOutputStream fos=new FileOutputStream("./src/test/resources/data.properties");
		property.store(fos, "Updated file successfully");
				

	}

}
