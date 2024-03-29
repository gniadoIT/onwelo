package it.gniado.onwelo.service;

import it.gniado.onwelo.model.Figure;
import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.repository.VoterRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VoterServiceTest {

    public static final int VOTERS_AMOUNT = 12;
    private VoterService voterService;
    private VoterRepository voterRepository;

    @BeforeEach
    void setup(){
        voterRepository = new VoterRepository();
        voterService = new VoterService(voterRepository);

        addVoters(VOTERS_AMOUNT);
    }

    private void addVoters(int amount) {
        for (int i = 0; i < amount; i++) {
            voterRepository.addVoter(new Voter(new Figure(RandomStringUtils.randomAlphabetic(10))));
        }
    }

    @Test
    void testAddVoter(){
        // GIVEN
        String name = "Qwerty";

        // WHEN
        voterService.addVoter(name);

        // THEN
        assertEquals(voterRepository.getAll().size(), VOTERS_AMOUNT+1);
    }

    @Test
    void testGetAllVoters(){
        // GIVEN NO DATA

        // WHEN
        List<Voter> voters = voterService.getAllVoters();

        // THEN
        assertFalse(voters.isEmpty());
        assertEquals(voters.size(), VOTERS_AMOUNT);
    }

    @Test
    void testAddVoterTwice(){
        // GIVEN
        String voterName = "Qwerty";
        voterService.addVoter(voterName);

        // WHEN
        Voter added = voterService.addVoter(voterName);

        // THEN
        assertNull(added);
    }

}
