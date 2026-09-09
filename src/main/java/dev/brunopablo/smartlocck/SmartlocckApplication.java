package dev.brunopablo.smartlocck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class SmartlocckApplication{

	public static void main(String[] args) {
		SpringApplication.run(SmartlocckApplication.class, args);
	}

}