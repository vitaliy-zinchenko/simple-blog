package zinjvi.zinjvi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zinchenko on 25.10.14.
 */
@ComponentScan(basePackages = {"/zinjvi/controllers", "/zinjvi"})
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

@Configuration
@ImportResource("/context.xml")
class XmlImportingConfiguration {
}
