package utilities;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonDataReader {

	public static JsonObject readJsonFromResource(String resourcePath) {

		try (InputStream is = Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream(resourcePath)) {

			if (is == null) {
				throw new RuntimeException("JSON file not found: " + resourcePath);
			}

			return JsonParser.parseReader(
					new InputStreamReader(is, StandardCharsets.UTF_8))
					.getAsJsonObject();

		} catch (Exception e) {
			throw new RuntimeException("Failed to read JSON file.", e);
		}
	}
}