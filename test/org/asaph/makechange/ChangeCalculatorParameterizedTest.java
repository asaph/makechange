package org.asaph.makechange;

import static org.junit.Assert.*;
import static org.asaph.makechange.ChangeCalculator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ChangeCalculatorParameterizedTest {
	private int price;
	private int tendered;
	private int change;
	private Map<Integer,Integer> expected;

	public ChangeCalculatorParameterizedTest(int price, int tendered, int change, Map<Integer, Integer> expected) {
		this.price = price;
		this.tendered = tendered;
		this.change = change;
		this.expected = expected;
	}

	@Parameters(name="Change = {2} cents")
	public static List<Object[]> getParameters() {
		int tendered = 100;
		List<Object[]> params = new ArrayList<>();
		for (int quarters = 0; quarters < 4; quarters++) {
			for (int dimes = 0; dimes <= 2; dimes++) {
				for (int nickels = 0; nickels < 2; nickels++) {
					// oddball special case. We'd rather use a quarter vs. 2 dimes and a nickel
					if (dimes == 2 && nickels == 1) {
						continue;
					}
					for (int pennies = 0; pennies < 5; pennies++) {
						int change = quarters * QUARTER + dimes * DIME + nickels * NICKEL + pennies * PENNY;
						int price = tendered - change;
						System.out.println(price + " --> " + change);
						Map<Integer, Integer> expected = new HashMap<>();
						if (quarters > 0) {
							expected.put(QUARTER, quarters);
						}
						if (dimes > 0) {
							expected.put(DIME, dimes);
						}
						if (nickels > 0) {
							expected.put(NICKEL, nickels);
						}
						if (pennies > 0) {
							expected.put(PENNY, pennies);
						}
						params.add(new Object[] { price, tendered, change, expected });
					}
				}
			}
		}
		return params;
	}

	@Test
	public void testChangeCalculator() {
		ChangeCalculator changeCalculator = new ChangeCalculator();
		Map<Integer,Integer> actual = changeCalculator.makeChange(price, tendered);
		assertEquals(expected, actual);
	}

	@Test
	public void testChangeCalculatorVariableDenominations() {
		ChangeCalculatorVariableDenominations changeCalculator = new ChangeCalculatorVariableDenominations(DENOMINATIONS);
		Map<Integer,Integer> actual = changeCalculator.makeChange(price, tendered);
		assertEquals(expected, actual);
	}
}
