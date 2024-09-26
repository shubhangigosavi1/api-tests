package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	FileInputStream fis = null;
	Properties pro = null;
	String filepath;

	public PropertiesReader() {	
		try {
			filepath = System.getProperty("user.dir")+"/config.properties";
			fis = new FileInputStream(filepath);
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
	}
	
	public String getPropValue(String key) {
		return pro.getProperty(key);
	}

	public void setPropValue(String key, String value) {
		pro.setProperty(key,value);
		pro.put(key, value);
	}
}
