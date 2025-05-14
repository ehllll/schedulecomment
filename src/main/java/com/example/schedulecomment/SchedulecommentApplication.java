package com.example.schedulecomment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchedulecommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulecommentApplication.class, args);
	}

}
