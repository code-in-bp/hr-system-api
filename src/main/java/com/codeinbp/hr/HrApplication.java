package com.codeinbp.hr;

import com.codeinbp.hr.repository.HireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrApplication {


	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}
}
