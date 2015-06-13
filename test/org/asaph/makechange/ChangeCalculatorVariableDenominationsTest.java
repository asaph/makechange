package org.asaph.makechange;

import static org.asaph.makechange.ChangeCalculator.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ChangeCalculatorVariableDenominationsTest {

	@Test
	public void testMakeChangeNineCents() {
		ChangeCalculatorVariableDenominations changeCalculator = new ChangeCalculatorVariableDenominations(1, 4, 5, 6);
		Map<Integer,Integer> expected = new HashMap<>();
		expected.put(5, 1);
		expected.put(4, 1);
		Map<Integer,Integer> actual = changeCalculator.makeChange(991, 1000);
		assertEquals(expected, actual);
	}

	@Test
	public void testMakeChangeTenCents() {
		ChangeCalculatorVariableDenominations changeCalculator = new ChangeCalculatorVariableDenominations(1, 4, 5, 6);
		Map<Integer,Integer> expected = new HashMap<>();
		expected.put(6, 1);
		expected.put(4, 1);
		Map<Integer,Integer> actual = changeCalculator.makeChange(990, 1000);
		assertEquals(expected, actual);
	}

	@Test
	public void testMakeChangeQuartersDimesNickelsPennies() {
		ChangeCalculatorVariableDenominations changeCalculator = new ChangeCalculatorVariableDenominations(DENOMINATIONS);
		Map<Integer,Integer> expected = new HashMap<>();
		expected.put(QUARTER, 2);
		expected.put(DIME, 1);
		expected.put(PENNY, 3);
		Map<Integer,Integer> actual = changeCalculator.makeChange(937, 1000);
		assertEquals(expected, actual);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidInput() {
		ChangeCalculatorVariableDenominations changeCalculator = new ChangeCalculatorVariableDenominations(DENOMINATIONS);
		changeCalculator.makeChange(937, 500);
	}
}
