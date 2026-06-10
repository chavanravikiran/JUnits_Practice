package com.junit.junit.service;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.junit.junit.entity.Employee;
import com.junit.junit.repository.EmployeeRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//JUnit for Save Employee
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveEmployeeTest() {
		
		Employee employee =Employee.builder()
				.firstName("Ravikiran")
				.lastName("Chavan")
				.email("abc@gmail.com")
				.build();
	
		employeeRepository.save(employee);
		
		Assertions.assertThat(employee.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void getEmployeeTest() {
		Employee employee= employeeRepository.findById(1L).get();
		Assertions.assertThat(employee.getId().equals(1L));
	}
	
	@Test
	@Order(3)
	public void getListEmployeeTest() {
		List<Employee> employee= employeeRepository.findAll();
		Assertions.assertThat(employee.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateEmployeeTest() {
		Employee employee= employeeRepository.findById(1L).get();
		employee.setEmail("ravikiran@gmail.com");
		Employee employeeUpdated =employeeRepository.save(employee);
		
//		Assertions.assertThat(employee.getEmail().equals("ravikiran@gmail.com"));
		Assertions.assertThat(employee.getEmail()).isEqualTo("ravikiran@gmail.com");
	}
	
	//Delete Operation
	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteEmployeeTest() {
		Employee employee = employeeRepository.findById(1L).get();
		employeeRepository.delete(employee);
		
		Employee employee1 = null; 
		Optional<Employee> optionalemployee = employeeRepository.findByEmail("ravikiran@gmail.com");
//		Assertions.assertThat()
		
		if(optionalemployee.isPresent()) {
			employee1=optionalemployee.get();
		}
		Assertions.assertThat(employee1).isNull();
	}
}
