package org.asaph.makechange;

import static org.asaph.makechange.ChangeCalculator.DIME;
import static org.asaph.makechange.ChangeCalculator.PENNY;
import static org.asaph.makechange.ChangeCalculator.QUARTER;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ChangeCalculatorTest {

	@Test
	public void testMakeChange() {
		ChangeCalculator changeCalculator = new ChangeCalculator();
		Map<Integer,Integer> expected = new HashMap<>();
		expected.put(QUARTER, 2);
		expected.put(DIME, 1);
		expected.put(PENNY, 3);
		Map<Integer,Integer> actual = changeCalculator.makeChange(937, 1000);
		assertEquals(expected, actual);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidInput() {
		ChangeCalculator changeCalculator = new ChangeCalculator();
		changeCalculator.makeChange(937, 500);
	}
}
