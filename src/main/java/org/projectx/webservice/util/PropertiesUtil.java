package org.projectx.webservice.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static Properties props = new Properties();

	static {
		try {
			props.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getPropertyValue(String key) {
		if (key == null) {
			return null;
		}
		return props.getProperty(key);
	}

	public static void setPropertyValue(String key, String value) {
		OutputStream out;
		try {
			out = new FileOutputStream("application.properties");
			props.setProperty(key, value);
			props.store(out, "Update " + key + " name");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getPropertyValue("clearguestPassword"));
	}
}
