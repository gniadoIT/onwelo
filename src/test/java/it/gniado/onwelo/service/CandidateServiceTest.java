package it.gniado.onwelo.service;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Figure;
import it.gniado.onwelo.repository.CandidateRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class CandidateServiceTest {

    public static final int CANDIDATES_AMOUNT = 5;
    private CandidateService candidateService;
    private CandidateRepository candidateRepository;

    @BeforeEach
    void setup(){
        candidateRepository = new CandidateRepository();
        candidateService = new CandidateService(candidateRepository);
        addCandidates(CANDIDATES_AMOUNT);
    }

    private void addCandidates(int amount) {
        for (int i = 0; i < amount; i++) {
            candidateRepository.addCandidate(new Candidate(new Figure(RandomStringUtils.randomAlphabetic(10))));
        }
    }

    @Test
    void testAddCandidate(){
        // GIVEN
        String candidateName = "Qwerty";

        // WHEN
        candidateService.addCandidate(candidateName);

        // THEN
        verify(candidateRepository).addCandidate(any(Candidate.class));
        assertEquals(candidateRepository.getAll().size(), CANDIDATES_AMOUNT+1);
    }

    @Test
    void testGetAllCandidates(){
        // GIVEN NO DATA

        // WHEN
        List<Candidate> candidates = candidateService.getAllCandidates();

        // THEN
        assertFalse(candidates.isEmpty());
        assertEquals(candidates.size(), CANDIDATES_AMOUNT);
    }
}
