package org.asaph.makechange;

import java.util.HashMap;
import java.util.Map;

public class ChangeCalculator {
	public static final int HUNDRED = 10000;
	public static final int FIFTY = 5000;
	public static final int TWENTY = 2000;
	public static final int TEN = 1000;
	public static final int FIVE = 500;
	public static final int DOLLAR = 100;
	public static final int QUARTER = 25;
	public static final int DIME = 10;
	public static final int NICKEL = 5;
	public static final int PENNY = 1;
	public static final int[] DENOMINATIONS = { HUNDRED, FIFTY, TWENTY, TEN, FIVE, DOLLAR, QUARTER, DIME, NICKEL, PENNY };

	public Map<Integer,Integer> makeChange(int price, int tendered) {
		if (tendered < price) {
			throw new IllegalArgumentException("Insufficient funds!");
		}
		int changeRemaining = tendered - price;
		Map<Integer,Integer> changeAmounts = new HashMap<>();
		for (int denomination : DENOMINATIONS) {
			int remainder = changeRemaining % denomination;
			int numCoins = (changeRemaining - remainder) / denomination;
			if (numCoins > 0) {
				changeAmounts.put(denomination, numCoins);
			}
			changeRemaining = remainder;
		}
		return changeAmounts;
	}
}
