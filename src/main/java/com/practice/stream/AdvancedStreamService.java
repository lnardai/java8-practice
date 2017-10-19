package com.practice.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.stream.model.ForeignAgent;
import com.practice.stream.model.Skill;

public class AdvancedStreamService {

	private String fileName = "big_text_file.txt";

	public long countWordInBigFile() {
		return createStreamFromFile().filter(line -> line.contains("Sherlock")).count();
	}

	public List<ForeignAgent> mergeAgentsBySkill(List<ForeignAgent> secretAgents, List<ForeignAgent> diplomats, Skill skill) {
		return Stream.concat(secretAgents.stream(), diplomats.stream())
				.filter(i -> filterBySkill(i, skill))
				.collect(Collectors.toList());
	}

	private Stream<String> createStreamFromFile() {
		String filePath = this.getClass().getClassLoader().getResource(fileName).getPath();
		try {
			return Files.lines(Paths.get(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return Stream.empty();
	}

	private boolean filterBySkill(ForeignAgent i, Skill skill){
		return i.getSkill().equals(skill);
	}
}
