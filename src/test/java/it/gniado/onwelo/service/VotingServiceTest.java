package it.gniado.onwelo.service;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Figure;
import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.repository.CandidateRepository;
import it.gniado.onwelo.repository.VoterRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class VotingServiceTest {

    public static final int VOTERS_AMOUNT = 3;
    public static final int CANDIDATES_AMOUNT = 5;
    private VotingService votingService;
    private VoterRepository voterRepository;
    private CandidateRepository candidateRepository;

    @BeforeEach
    void setup(){
        voterRepository = new VoterRepository();
        candidateRepository = new CandidateRepository();
        votingService = new VotingService(voterRepository, candidateRepository);

        addVoters(VOTERS_AMOUNT);
        addCandidates(CANDIDATES_AMOUNT);
    }

    private void addVoters(int amount) {
        for (int i = 0; i < amount; i++) {
            voterRepository.addVoter(new Voter(new Figure(RandomStringUtils.randomAlphabetic(10))));
        }
    }

    private void addCandidates(int amount) {
        for (int i = 0; i < amount; i++) {
            candidateRepository.addCandidate(new Candidate(new Figure(RandomStringUtils.randomAlphabetic(10))));
        }
    }

    @Test
    void testVote(){
        // GIVEN
        int voterId = Integer.parseInt(RandomStringUtils.randomNumeric(1)) % VOTERS_AMOUNT;
        int candidateId = Integer.parseInt(RandomStringUtils.randomNumeric(1)) % CANDIDATES_AMOUNT;

        // WHEN
        votingService.addVote(voterId, candidateId);

        // THEN
        Assertions.assertTrue(voterRepository.getById(voterId).isHasVoted());
        Assertions.assertEquals(candidateRepository.getCandidateById(candidateId).getVotes(), 1);
    }

}
