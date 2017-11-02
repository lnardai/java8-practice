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
	public void sortList() throws Exception {
		Map<Agent, Long> result = service.sortMapByValue(agentsWithSalary);
		Iterator<Map.Entry<Agent, Long>> iterator = result.entrySet().iterator();
		assertEquals(5, result.size());
		assertEquals("Pichael", iterator.next().getKey().getName());
		assertEquals("Stephanie", iterator.next().getKey().getName());
	}

	@Test
	public void activateAllAgentsWithRookieSkill() throws Exception {
		service.activateAllAgentsWith(diplomats, Skill.ROOKIE);
		assertEquals(true, diplomats.get(0).isActivated());
		assertEquals(true, diplomats.get(1).isActivated());
		assertEquals(false, diplomats.get(2).isActivated());
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
	public void partitionBasedOnSkill() throws Exception {
		Map<Boolean, List<Agent>> result = service.partitionListBySalary(diplomats, Skill.GODLIKE);
		List<Agent> godLikeAgents = result.get(true);
		List<Agent> others = result.get(false);
		assertEquals(1, godLikeAgents.size());
		assertEquals("Stephanie", godLikeAgents.get(0).getName());
		assertEquals(3, others.size());
	}

	@Test
	public void mergeFromTwoListsBySkill() throws Exception {
		List<Agent> result = service.mergeAgentsBySkill(secretAgents, diplomats, Skill.PRO);
		assertEquals(1, result.size());
		assertEquals("Clara", result.get(0).getName());

	}

	private static void initLists() {
		Location defaultLocation = new Location(new Date(), "Australia");
		Location defaultLocation1 = new Location(new Date(), "Europe");
		Location defaultLocation2 = new Location(new Date(), "America");
		Location defaultLocation3 = new Location(new Date(), "Europe");
		Location defaultLocation4 = new Location(new Date(), "Antarctica");
		Collections.addAll(secretAgents,
				new SecretAgentModel("Frank", defaultLocation, Skill.ROOKIE),
				new SecretAgentModel("Joel", defaultLocation1, Skill.GODLIKE),
				new SecretAgentModel("Greg", defaultLocation2, Skill.INTERMEDIATE),
				new SecretAgentModel("Stephanie", defaultLocation3, Skill.GODLIKE));

		Collections.addAll(diplomats,
				new SecretAgentModel("Michael", defaultLocation, Skill.ROOKIE),
				new SecretAgentModel("Rick", defaultLocation1, Skill.ROOKIE),
				new SecretAgentModel("Clara", defaultLocation2, Skill.PRO),
				new SecretAgentModel("Stephanie", defaultLocation3, Skill.GODLIKE));

		agentsWithSalary.put(new SecretAgentModel("Michael", defaultLocation, Skill.ROOKIE), 15L);
		agentsWithSalary.put(new SecretAgentModel("Pichael", defaultLocation1, Skill.GODLIKE), 63L);
		agentsWithSalary.put(new SecretAgentModel("Rick", defaultLocation2, Skill.ROOKIE), 5L);
		agentsWithSalary.put(new SecretAgentModel("Clara", defaultLocation3, Skill.PRO), 19L);
		agentsWithSalary.put(new SecretAgentModel("Stephanie", defaultLocation4, Skill.GODLIKE), 55L);
	}

}