package com.junit.junit.service;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTestJUnit5 {

	@BeforeAll
	public static void init() {
		System.out.println("Execute Before all Test Case execute onces:"+new Date());
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("Execute Before Each Test Case :"+new Date());
	}
	@Test
	public void addTwoNumberTest() {
		int actualResult =CalculatorService.addTwoNumbers(12, 12);
		int expectedResult = 24;
		Assertions.assertEquals(expectedResult,actualResult,"Result Not Match");
	}
	
	@Test
	public void addAnyNumbersTest() {
			int actualResult = CalculatorService.sumAnyNumber(10,10,2,10);
			int expectedResult = 32;
			Assertions.assertEquals(expectedResult , actualResult);
	}
	
	@Test
	public void checkArrayEquals() {
		int actual []= {1,2,3,4,5};
		int expected  []= {1,2,3,4,5};
		
		Assertions.assertArrayEquals(expected , actual);
	}
	
	@AfterEach
	public void reset() {
		System.out.println("Execute after all Test Case execute onces - use for reset counter :"+new Date());
	}
	
	@AfterAll
	public static void destroy() {
		System.out.println("Execute after all Test Case execute onces - use for destroy and reset counter :"+new Date());
	}
}
