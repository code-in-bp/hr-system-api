package com.codeinbp.hr;

import com.codeinbp.hr.model.Hire;
import com.codeinbp.hr.repository.HireRepository;
import com.codeinbp.hr.utils.SearchBySerialNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HrApplication {

	private static  HireRepository hireRepository;


	public HrApplication(HireRepository hireRepository) {
		this.hireRepository = hireRepository;
	}



	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);

		List<Hire> getHires = hireRepository.findAllHires();


		String x = SearchBySerialNumber.searchBySerialNumber.apply("HR12345", getHires);
		System.out.println("Hire By serial Number: " + x);

	}
}
