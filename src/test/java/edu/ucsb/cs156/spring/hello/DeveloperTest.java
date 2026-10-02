package edu.ucsb.cs156.spring.hello;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeveloperTest {

    Team team;

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Tom M.", Developer.getName());
    }

    @Test 
    public void getGithubId_returns_correct_id() {
        assertEquals("td-marsters", Developer.getGithubId());
    }

    @BeforeEach 
    public void setup_tested_team() {
        team = new Team("f26-09");
        team.addMember("Tom M.");
        team.addMember("Amaya B.");
        team.addMember("Aryan V.");
        team.addMember("Jerry Y.");
        team.addMember("Bogdan S.");
    }

    @Test 
    public void getTeam_returns_correct_team_name() {
        assertEquals(team.getName(), Developer.getTeam().getName());
    }

    @Test 
    public void getTeam_returns_correct_team_members() {
        assertEquals(team.getMembers(), Developer.getTeam().getMembers());
    }

}
