package Temp;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		int a = 1234;
		int b = 5678;
		int result = calculator.add(a, b);
		
		int expected = 6912;
		
		assertEquals(expected, result);
	}

}
