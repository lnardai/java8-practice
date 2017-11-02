package com.practice.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class BasicStreamAggregateServiceTest {

	private static List<Integer> exampleNumberList = new ArrayList<>();
	private BasicStreamAggregateService service = new BasicStreamAggregateService();

	@BeforeClass
	public static void initData(){
		fillArray();
	}

	@Test
	public void getAverage() throws Exception {
		assertEquals(3.5, service.getAvarage(exampleNumberList), 0.5);
	}

	@Test
	public void getSum() throws Exception {
		assertEquals(23, service.getSum(exampleNumberList));
	}

	@Test
	public void getPositiveSum() throws Exception {
		assertEquals(26, service.positiveSum(exampleNumberList));
	}

	@Test
	public void findFirstBiggerThan() throws Exception {
		assertEquals(13, service.getFirstBiggerThan(exampleNumberList, 10));
	}

	@Test
	public void summaryStatistics() throws Exception {
		IntSummaryStatistics statistics = service.sumStatistics(exampleNumberList);
		assertEquals(13, statistics.getMax());
		assertEquals(-3, statistics.getMin());
		assertEquals(6, statistics.getCount());
	}

	@Test
	public void countZeroes() throws Exception {
		assertEquals(2, service.countZeroes(exampleNumberList));
	}

	private static void fillArray(){
		exampleNumberList.add(3);
		exampleNumberList.add(10);
		exampleNumberList.add(13);
		exampleNumberList.add(0);
		exampleNumberList.add(0);
		exampleNumberList.add(-3);
	}
}