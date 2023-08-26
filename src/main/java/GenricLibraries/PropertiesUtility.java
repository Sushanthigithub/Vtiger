package GenricLibraries;

/**
 * This Class Contains reusable methods to perform operations on Properties file
 * @author HOME
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	private Properties property;

	/**
	 * This method is used to initialized the properties
	 * 
	 * @param filepath
	 */
	public void propertiesInitialiation(String filepath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to read data from properties
	 * 
	 * @param Key
	 * @return
	 */

	public String readFromPropeties(String Key) 
	{
		return property.getProperty(Key);
	}
}
