package com.skillmentor.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@EnableCaching
@SpringBootApplication
public class SkillMentorRootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SkillMentorRootApplication.class, args);
	}
}
