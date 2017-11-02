package com.practice.stream;

import java.util.IntSummaryStatistics;
import java.util.List;

public class BasicStreamAggregateService {

	public double getAvarage(List<Integer> numbers) {
		return numbers.stream().mapToInt(i -> i).average().orElse(0);
	}

	public int getFirstBiggerThan(List<Integer> numbers, int limit) {
		return numbers.stream().filter(i -> i > limit).findFirst().orElse(0);
	}

	public int getSum(List<Integer> numbers) {
		return numbers.stream().mapToInt(i -> i).sum();
	}

	public int positiveSum(List<Integer> numbers) {
		return numbers.stream().filter(i -> i > 0).mapToInt(i -> i).sum();
	}

	public IntSummaryStatistics sumStatistics(List<Integer> numbers) {
		return numbers.stream().mapToInt(i -> i).summaryStatistics();
	}

	public long countZeroes(List<Integer> numbers) {
		return numbers.stream().filter(i -> i == 0).count();
	}
}
