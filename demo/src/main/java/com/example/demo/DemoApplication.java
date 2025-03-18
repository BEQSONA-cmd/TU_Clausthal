package com.example.demo;

import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.repository.EmployeeRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public void createEmployee(String firstName, String lastName, String email) {
        Employee employee = new Employee(firstName, lastName, email);
        employeeRepository.save(employee);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 20; i++) {
            createEmployee("some" + i, "some" + i, "some" + i + "@mail.com");
        }

        System.out.println("Saved data: ");
        employeeRepository.findAll().forEach(employee -> System.out.println(employee));
    }
}