package com.programmingtechie.studentservice;

import com.programmingtechie.studentservice.model.Student;
import com.programmingtechie.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@RequiredArgsConstructor
public class StudentServiceApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	private final StudentRepository studentRepository;

	@Override
	public void run(String... args) {
		if (studentRepository.count() < 1) {
			Student student = new Student();
			student.setFullname("Abbas chokor");
			student.setFathername("Houssein");
			student.setMatricule("192474");
			student.setEmail("Abbas.chokor@hotmail.com");
			studentRepository.save(student);
		}
	}

}
