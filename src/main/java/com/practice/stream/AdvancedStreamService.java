package com.practice.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.stream.model.Agent;
import com.practice.stream.model.Skill;

public class AdvancedStreamService {

	private String fileName = "./big_text_file.txt";

	public long countWordInBigFile() {
		return createStreamFromFile().filter(line -> line.contains("Sherlock")).count();
	}

	public Map<Skill, Long> groupBySimple(List<Agent> items) {
		return items.stream().collect(Collectors.groupingBy(item -> item.getSkill(), Collectors.counting()));
	}

	public Map<Agent, Long> sortMapByValue(Map<Agent, Long> agentsWithSalary) {
		return agentsWithSalary.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}

	public List<Agent> mergeAgentsBySkill(List<Agent> secretAgents, List<Agent> diplomats, Skill skill) {
		return Stream.concat(secretAgents.stream(), diplomats.stream())
				.filter(i -> filterBySkill(i, skill))
				.collect(Collectors.toList());
	}

	private Stream<String> createStreamFromFile() {
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
			return Files.lines(path);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(URISyntaxException e) {
			e.printStackTrace();
		}
		return Stream.empty();
	}

	private boolean filterBySkill(Agent i, Skill skill) {
		return i.getSkill().equals(skill);
	}
}
