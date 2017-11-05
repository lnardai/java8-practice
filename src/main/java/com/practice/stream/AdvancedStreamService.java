package com.practice.stream;

import static java.util.stream.Collectors.partitioningBy;

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

	public long countWordInBigFile(String wordToCount) {
		return createStreamFromFile().filter(line -> line.contains(wordToCount)).count();
	}

	public Map<Skill, Long> groupBySkill(List<Agent> items) {
		throw new UnsupportedOperationException("Not implemented");
	}


	/*
	* Receive an unordered Map, and sort it by the Map's value, hint: LinkedHashMap
	* */
	public Map<Agent, Long> sortMapByValue(Map<Agent, Long> agentsWithSalary) {
		throw new UnsupportedOperationException("Not implemented");
	}

	/*
	* Get the merged result of both list who have the same skill.
	* */
	public List<Agent> mergeAgentsBySkill(List<Agent> secretAgents, List<Agent> diplomats, Skill skill) {
		throw new UnsupportedOperationException("Not implemented");
	}

	/*
	* Change the original list elements and active all Agents with submitted skills.
	* */
	public void activateAllAgentsWith(List<Agent> agents, Skill usedSkill) {
		throw new UnsupportedOperationException("Not implemented");
	}


	public Map<Boolean, List<Agent>> partitionListBySalary(List<Agent> agents, Skill skill){
		throw new UnsupportedOperationException("Not implemented");
	}

	/*
	* Utility for reading files as a stream.
	* */
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
