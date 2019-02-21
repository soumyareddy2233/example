package vendorconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import vendorconfiguration.property.FileStorageProperties;



@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class VendorconfigurationEapServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorconfigurationEapServicesApplication.class, args);
	}
}
