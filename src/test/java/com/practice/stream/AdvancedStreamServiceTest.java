package com.practice.stream;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.practice.stream.model.ForeignAgent;
import com.practice.stream.model.Location;
import com.practice.stream.model.SecretAgentModel;
import com.practice.stream.model.Skill;

public class AdvancedStreamServiceTest {

	private AdvancedStreamService service =  new AdvancedStreamService();
	private static List<ForeignAgent> secretAgents =  new ArrayList<>();
	private static List<ForeignAgent> diplomats =  new ArrayList<>();

	@BeforeClass
	public static void setUp() throws Exception {
		initLists();
	}

	@Test
	public void countWordInBigFile() throws Exception {
		assertEquals(95, service.countWordInBigFile());
	}

	@Test
	public void groupBySimpleExample() throws Exception {
		Map<Skill, Long> result =service.groupBySimple(secretAgents);
		assertEquals(3, result.size());
		assertEquals(1, result.get(Skill.ROOKIE).longValue());
		assertEquals(2, result.get(Skill.GODLIKE).longValue());
		assertEquals(1, result.get(Skill.INTERMEDIATE).longValue());

	}

	@Test
	public void mergeFromTwoListsBySkill() throws Exception {
		List<ForeignAgent> result = service.mergeAgentsBySkill(secretAgents, diplomats, Skill.PRO);
		assertEquals(1, result.size());
		assertEquals("Clara", result.get(0).getName());

	}

	public static void initLists(){
		Location defaultLocaiton = new Location(new Date(), "Australia");
		Collections.addAll(secretAgents,
				new SecretAgentModel("Frank", defaultLocaiton, Skill.ROOKIE),
				new SecretAgentModel("Joel", defaultLocaiton, Skill.GODLIKE),
				new SecretAgentModel("Greg", defaultLocaiton, Skill.INTERMEDIATE),
				new SecretAgentModel("Stephanie", defaultLocaiton, Skill.GODLIKE));

		Collections.addAll(diplomats,
				new SecretAgentModel("Michael", defaultLocaiton, Skill.ROOKIE),
				new SecretAgentModel("Rick", defaultLocaiton, Skill.ROOKIE),
				new SecretAgentModel("Clara", defaultLocaiton, Skill.PRO),
				new SecretAgentModel("Stephanie", defaultLocaiton, Skill.GODLIKE));
	}




}