package com.practice.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.stream.model.ForeignAgent;
import com.practice.stream.model.SecretAgentModel;
import com.practice.stream.model.Skill;

public class AdvancedStreamService {

	private String fileName = "./big_text_file.txt";

	public long countWordInBigFile() {
		return createStreamFromFile().filter(line -> line.contains("Sherlock")).count();
	}

	public Map<Skill, Long> groupBySimple(List<ForeignAgent> items) {
		return items.stream().map(item-> item.getSkill()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	}

	public List<ForeignAgent> mergeAgentsBySkill(List<ForeignAgent> secretAgents, List<ForeignAgent> diplomats, Skill skill) {
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

	private boolean filterBySkill(ForeignAgent i, Skill skill) {
		return i.getSkill().equals(skill);
	}
}
