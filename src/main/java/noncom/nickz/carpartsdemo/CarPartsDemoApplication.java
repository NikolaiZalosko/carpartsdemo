package noncom.nickz.carpartsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = "noncom.nickz.carpartsdemo.repository")
public class CarPartsDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarPartsDemoApplication.class, args);
  }

}
