package operations;

/**
 * IntegerOperationsTest purpose is to test IntegerOperations class.
 * 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-04-26
 */

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IntegerOperationsTest {

	IntegerOperations inop = new IntegerOperations();// Create IntegerOperations object.

	// Test if positive integers turn into negative.
	@Test
	public void test_positive() {
		Assert.assertEquals(-1, inop.reverseSign(1));
	}

	// Test if negative integers turn into positive.
	@Test
	public void test_negative() {
		Assert.assertEquals(1, inop.reverseSign(-1));
	}

	// Test case where value is 0.
	@Test
	public void test_zero() {
		Assert.assertEquals(0, inop.reverseSign(0));
	}

	// Add two positive integers. Test if the result is correct.
	@Test
	public void test_correctness() {
		Assert.assertEquals(12, inop.add(4, 8));
	}

	// Define an expected exception for cases that throw exception.
	@Rule
	public ExpectedException exception = ExpectedException.none();

	// Add a negative and a positive integer. Expect an exception.
	@Test
	public void test_positive_inputs() {
		exception.expect(IllegalArgumentException.class);
		inop.add(3, -2);
	}

	/**
	 * Add two integers where their sum causes integer overflow. Expect an
	 * exception.
	 */
	@Test
	public void test_Integer_Overflow() {
		exception.expect(IllegalArgumentException.class);
		inop.add(200000000, 2000000000);
	}

	/**
	 * Test powerOfTwo method when is given negative integer as an input. Expect an
	 * exception.
	 */
	@Test
	public void test_powerOfTwo_negative() {
		exception.expect(IllegalArgumentException.class);
		inop.powerOfTwo(-1);
	}

	/**
	 * Test powerOfTwo method when is given integer big enough to cause integer
	 * overflow. Expect an exception.
	 */
	@Test
	public void test_powerOfTwo_Overflow() {
		exception.expect(IllegalArgumentException.class);
		inop.powerOfTwo(31);
	}
}
