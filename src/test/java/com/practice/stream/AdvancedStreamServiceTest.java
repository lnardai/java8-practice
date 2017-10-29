package com.practice.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.practice.stream.model.Agent;
import com.practice.stream.model.Location;
import com.practice.stream.model.SecretAgentModel;
import com.practice.stream.model.Skill;

public class AdvancedStreamServiceTest {

	private AdvancedStreamService service = new AdvancedStreamService();
	private static Map<Agent, Long> agentsWithSalary = new HashMap<>();
	private static List<Agent> secretAgents = new ArrayList<>();
	private static List<Agent> diplomats = new ArrayList<>();

	@BeforeClass
	public static void setUp() throws Exception {
		initLists();
	}

	@Test
	public void countWordInBigFile() throws Exception {
		assertEquals(95, service.countWordInBigFile("Sherlock"));
	}

	@Test
	public void activateAllAgentsWithRookieSkill() throws Exception {
		service.activateAllAgentsWith(diplomats, Skill.ROOKIE);
		assertEquals(true, diplomats.get(0).isActivated());
		assertEquals(true, diplomats.get(1).isActivated());
		assertEquals(false, diplomats.get(2).isActivated());
	}

	@Test
	public void sortList() throws Exception {
		Map<Agent, Long> result = service.sortMapByValue(agentsWithSalary);
		Iterator<Map.Entry<Agent, Long>> iterator = result.entrySet().iterator();
		assertEquals(5, result.size());
		assertEquals("Pichael", iterator.next().getKey().getName());
		assertEquals("Stephanie", iterator.next().getKey().getName());
	}

	@Test
	public void groupBySimpleExample() throws Exception {
		Map<Skill, Long> result = service.groupBySkill(secretAgents);
		assertEquals(3, result.size());
		assertEquals(1, result.get(Skill.ROOKIE).longValue());
		assertEquals(2, result.get(Skill.GODLIKE).longValue());
		assertEquals(1, result.get(Skill.INTERMEDIATE).longValue());
	}

	@Test
	public void mergeFromTwoListsBySkill() throws Exception {
		List<Agent> result = service.mergeAgentsBySkill(secretAgents, diplomats, Skill.PRO);
		assertEquals(1, result.size());
		assertEquals("Clara", result.get(0).getName());

	}

	public static void initLists() {
		Location defaultLocation = new Location(new Date(), "Australia");
		Collections.addAll(secretAgents,
				new SecretAgentModel("Frank", defaultLocation, Skill.ROOKIE),
				new SecretAgentModel("Joel", defaultLocation, Skill.GODLIKE),
				new SecretAgentModel("Greg", defaultLocation, Skill.INTERMEDIATE),
				new SecretAgentModel("Stephanie", defaultLocation, Skill.GODLIKE));

		Collections.addAll(diplomats,
				new SecretAgentModel("Michael", defaultLocation, Skill.ROOKIE),
				new SecretAgentModel("Rick", defaultLocation, Skill.ROOKIE),
				new SecretAgentModel("Clara", defaultLocation, Skill.PRO),
				new SecretAgentModel("Stephanie", defaultLocation, Skill.GODLIKE));

		agentsWithSalary.put(new SecretAgentModel("Michael", defaultLocation, Skill.ROOKIE), 15L);
		agentsWithSalary.put(new SecretAgentModel("Pichael", defaultLocation, Skill.GODLIKE), 63L);
		agentsWithSalary.put(new SecretAgentModel("Rick", defaultLocation, Skill.ROOKIE), 5L);
		agentsWithSalary.put(new SecretAgentModel("Clara", defaultLocation, Skill.PRO), 19L);
		agentsWithSalary.put(new SecretAgentModel("Stephanie", defaultLocation, Skill.GODLIKE), 55L);
	}

}