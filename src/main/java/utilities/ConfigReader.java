package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static final Properties properties = new Properties();

	static {
		try (InputStream input = Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("config/config.properties")) {

			properties.load(input);

		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
