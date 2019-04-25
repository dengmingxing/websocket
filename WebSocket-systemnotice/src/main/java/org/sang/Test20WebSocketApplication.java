package org.sang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Test20WebSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(Test20WebSocketApplication.class, args);
	}
}
