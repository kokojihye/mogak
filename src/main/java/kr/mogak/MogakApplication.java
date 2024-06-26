package kr.mogak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MogakApplication {

	public static void main(String[] args) {
		SpringApplication.run(MogakApplication.class, args);
	}

}
