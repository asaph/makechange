package org.asaph.makechange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A solution to the Make Change problem using the "Dynamic Programming" technique.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Dynamic_programming">https://en.wikipedia.org/wiki/Dynamic_programming</a>
 */
public class ChangeCalculatorVariableDenominations {
	private int[] denominations;

	public ChangeCalculatorVariableDenominations(int ... denominations) {
		this.denominations = new int[denominations.length];
		System.arraycopy(denominations, 0, this.denominations, 0, denominations.length);
		Arrays.sort(this.denominations);
	}

	public Map<Integer,Integer> makeChange(int price, int tendered) {
		if (tendered < price) {
			throw new IllegalArgumentException("Insufficient funds!");
		}
		int change = tendered - price;
		int denominationCount = denominations.length;
		int[][] subProblems = new int[change + 1][denominationCount];
		for (int i=0; i<=change; i++) {
			int[] previousSubProblem = subProblems[i];
			for (int j=0; j<denominationCount; j++) {
				int denomination = denominations[j];
				int newAmount = i + denomination;
				if (newAmount > change) {
					break;
				}
				int[] solution = new int[denominationCount];
				System.arraycopy(previousSubProblem, 0, solution, 0, denominationCount);
				solution[j]++;
				int coinCountForBestSolutionSoFar = sum(subProblems[newAmount]);
				if (coinCountForBestSolutionSoFar == 0 || coinCountForBestSolutionSoFar > sum(solution)) {
					subProblems[newAmount] = solution;
				}
			}
		}

		Map<Integer,Integer> changeAmounts = new HashMap<>();
		for (int i=0; i<denominationCount; i++) {
			int numCoins = subProblems[change][i];
			if (numCoins > 0) {
				int denomination = denominations[i];
				changeAmounts.put(denomination, numCoins);
			}
		}
		return changeAmounts;
	}

	static int sum(int ... numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}
}
