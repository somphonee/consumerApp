package co.th.priorsolusion.marketplace.consummerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.th.priorsolusion.marketplace")
public class ConsummerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsummerAppApplication.class, args);
	}

}
