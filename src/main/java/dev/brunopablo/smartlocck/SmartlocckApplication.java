package dev.brunopablo.smartlocck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import dev.brunopablo.smartlocck.client.GoogleClient;

@SpringBootApplication
@EnableFeignClients
public class SmartlocckApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SmartlocckApplication.class, args);
	}

	@Autowired
	private GoogleClient googleClient;

	@Override
	public void run(String... args) throws Exception {
		
		googleClient.helloGoogle();
	}
}	