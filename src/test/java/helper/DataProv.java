package helper;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class DataProv {
	

	
	public static String prop(String property) {
		Properties prop = new Properties();
		InputStream input = null;
		String ghj = null;
		
		try {
			 
			input = new FileInputStream("config.properties");
	
			// load a properties file
			prop.load(input);
	
			// get the property value and print it out
			ghj = prop.getProperty(property);
		
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 		
		return ghj;
	}

}
