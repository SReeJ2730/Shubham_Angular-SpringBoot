package com.project.EventOrganiser;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.twilio.Twilio;

@EnableJpaRepositories(basePackages="com.dao")
@EntityScan(basePackages="com.model")
@SpringBootApplication(scanBasePackages="com")
public class EventOrganiserApplication {
	public static final String ACCOUNT_SID = "AC579c550305e26143971d0d03a29d4be5";
	public static final String AUTH_TOKEN = "d975335924a6af1810de5492c2daf773";

	public static void main(String[] args) {
		SpringApplication.run(EventOrganiserApplication.class, args);
	}
	@PostConstruct
	public void initTwilio(){
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}

}
