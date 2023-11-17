package it.gniado.onwelo.repository;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Figure;
import it.gniado.onwelo.model.Voter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class VoterRepositoryTest {

    private VoterRepository voterRepository;

    @BeforeEach
    void setup(){
        voterRepository = new VoterRepository();
        List<Voter> testVoters = List.of(
                createVoter(RandomStringUtils.randomAlphabetic(5)),
                createVoter(RandomStringUtils.randomAlphabetic(5)),
                createVoter(RandomStringUtils.randomAlphabetic(5))
        );
        voterRepository.addVoters(testVoters);
    }

    @Test
    void testAddVoter(){
        // GIVEN
        Voter testVoter = createVoter(RandomStringUtils.randomAlphabetic(5));
        int preModifySize = voterRepository.getAll().size();

        // WHEN
        voterRepository.addVoter(testVoter);

        // THEN
        List<Voter> modifiedVoters = voterRepository.getAll();
        Assertions.assertEquals(modifiedVoters.size(), preModifySize+1);
        Assertions.assertTrue(modifiedVoters.contains(testVoter));
    }

    @Test
    void testAddCandidates(){
        // GIVEN
        List<Voter> testVoters = List.of(
                createVoter(RandomStringUtils.randomAlphabetic(5)),
                createVoter(RandomStringUtils.randomAlphabetic(5)),
                createVoter(RandomStringUtils.randomAlphabetic(5))
        );
        int preModifySize = voterRepository.getAll().size();

        // WHEN
        voterRepository.addVoters(testVoters);

        // THEN
        List<Voter> modifiedVoters = voterRepository.getAll();
        Assertions.assertEquals(modifiedVoters.size(), preModifySize+testVoters.size());
        Assertions.assertTrue(modifiedVoters.containsAll(testVoters));
    }

    @Test
    void testVote(){
        // GIVEN
        int index = (int) (Math.random() * 10 % 3);
        voterRepository.getAll().forEach(v -> assertFalse(v.isHasVoted()));

        // WHEN
        voterRepository.vote(index);

        // THEN
        Assertions.assertTrue(voterRepository.getById(index).isHasVoted());
    }

    private Voter createVoter(String name){
        return new Voter(new Figure(name));
    }

}
