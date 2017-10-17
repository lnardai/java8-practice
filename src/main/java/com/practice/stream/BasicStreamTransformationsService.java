package com.practice.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicStreamTransformationsService {

	public List<String> removeDots(Map<Integer, String> names) {
		return names.entrySet().stream().map( element -> removeDots(element.getValue())).collect(Collectors.toList());
	}



	private String removeDots(String text){
		return text.replaceAll("\\.", " ");
	}
}
