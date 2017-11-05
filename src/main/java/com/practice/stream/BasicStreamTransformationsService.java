package com.practice.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicStreamTransformationsService {

	public List<String> removeDots(Map<Integer, String> names) {
		throw new UnsupportedOperationException("Not implemented");
	}

	public List<String> removeDuplicates(Map<Integer, String> names) {
		throw new UnsupportedOperationException("Not implemented");
	}

	public List<String> getFirstTwoWithName(Map<Integer, String> names, String nameCriteria) {
		throw new UnsupportedOperationException("Not implemented");
	}

	private String removeDots(String text){
		return text.replaceAll("\\.", " ");
	}
}
