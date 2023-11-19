package it.gniado.onwelo.repository;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Figure;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CandidateRepositoryTest {

    private CandidateRepository candidateRepository;

    @BeforeEach
    void setup(){
        candidateRepository = new CandidateRepository();
    }

    @Test
    void testAddCandidate(){
        // GIVEN
        Candidate testCandidate = createCandidate(RandomStringUtils.randomAlphabetic(5));
        int preModifySize = candidateRepository.getAll().size();

        // WHEN
        candidateRepository.addCandidate(testCandidate);

        // THEN
        List<Candidate> modifiedCandidates = candidateRepository.getAll();
        Assertions.assertEquals(modifiedCandidates.size(), preModifySize+1);
        Assertions.assertTrue(modifiedCandidates.contains(testCandidate));
    }

    @Test
    void testAddCandidates(){
        // GIVEN
        List<Candidate> testCandidates = List.of(
                createCandidate(RandomStringUtils.randomAlphabetic(5)),
                createCandidate(RandomStringUtils.randomAlphabetic(5)),
                createCandidate(RandomStringUtils.randomAlphabetic(5))
        );
        int preModifySize = candidateRepository.getAll().size();

        // WHEN
        candidateRepository.addCandidates(testCandidates);

        // THEN
        List<Candidate> modifiedCandidates = candidateRepository.getAll();
        Assertions.assertEquals(modifiedCandidates.size(), preModifySize+testCandidates.size());
        Assertions.assertTrue(modifiedCandidates.containsAll(testCandidates));
    }

    @Test
    void testVote(){
        // GIVEN
        List<Candidate> testCandidates = List.of(
                createCandidate(RandomStringUtils.randomAlphabetic(5)),
                createCandidate(RandomStringUtils.randomAlphabetic(5)),
                createCandidate(RandomStringUtils.randomAlphabetic(5))
        );
        candidateRepository.addCandidates(testCandidates);

        // WHEN
        int index = (int) (Math.random() * 10 % 3);
        candidateRepository.vote(testCandidates.get(index));

        // THEN
        Assertions.assertTrue(candidateRepository.getCandidateById(index).getVotes() == 1);
    }

    @Test
    void testCountVotes(){
        // GIVEN
        List<Candidate> testCandidates = List.of(
                createCandidate(RandomStringUtils.randomAlphabetic(5)),
                createCandidate(RandomStringUtils.randomAlphabetic(5)),
                createCandidate(RandomStringUtils.randomAlphabetic(5))
        );
        candidateRepository.addCandidates(testCandidates);
        int votesAmount = (int) (Math.random()*100);

        // WHEN
        int index = (int) (Math.random() * 10 % 3);
        for (int i = 0; i < votesAmount; i++) {
            candidateRepository.vote(testCandidates.get(index));
        }

        // THEN
        Assertions.assertTrue(candidateRepository.getCandidateById(index).getVotes() == votesAmount);
    }

    @Test
    void testAddCandidateTwice(){
        // GIVEN
        Candidate candidate = createCandidate("Qwerty");
        candidateRepository.addCandidate(candidate);

        // WHEN
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->candidateRepository.addCandidate(candidate));

        // THEN
        assertEquals(ex.getMessage(), "Candidates must be unique");
    }

    private Candidate createCandidate(String candidateName) {
        return new Candidate(new Figure(candidateName));
    }

}
