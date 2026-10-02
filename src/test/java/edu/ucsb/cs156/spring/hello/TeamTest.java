package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
        assert(team.getName().equals("test-team"));
    }

    @Test 
    public void equals_evaluates_true_case_correctly() {
        assertTrue(team.equals(team));
    }

    @Test 
    public void equals_evaluates_false_case_correctly() {
        assertFalse(team.equals(new Team()));
    }
    
    @Test 
    public void equals_evaluates_instance_difference_correctly() {
        assertFalse(team.equals(""));
    }

    @Test 
    public void equals_evaluates_equivalency_correctly() {
        team.addMember("Tom");
        Team test = new Team();
        test.setName(team.getName());
        test.setMembers(team.getMembers());
        assertTrue(team.equals(test));
    }

    @Test
    public void toString_returns_correct_String() {
        assertEquals(team.toString(), "Team(name=test-team, members=[])");
    }
}
