package jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

@SpringBootApplication
@EnableScheduling
public class TestApplication {

	public static void main(String[] args) {

		Yaml yaml = new Yaml();
		try (InputStream inputStream = new FileInputStream("src/main/resources/application-db.yml")) {
			Map<String, Object> data = yaml.load(inputStream);
			if (data != null) {
				Object serverSection = data.get("server");
				if (serverSection instanceof Map) {
					Map<String, Object> serverMap = (Map<String, Object>) serverSection;
					Object logValue = serverMap.get("month");
					if (logValue != null) {
						System.setProperty("server.month", String.valueOf(logValue));
					}
				}
			}
		}
		catch (Exception e) {

		}

		SpringApplication.run(TestApplication.class, args);
	}
}
