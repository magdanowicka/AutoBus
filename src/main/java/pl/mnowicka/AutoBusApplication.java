package pl.mnowicka;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoBusApplication {

	public static Logger log = Logger.getLogger(AutoBusApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(AutoBusApplication.class, args);
	}

}
