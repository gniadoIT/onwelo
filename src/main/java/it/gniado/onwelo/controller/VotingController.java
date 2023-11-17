package it.gniado.onwelo.controller;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.service.CandidateService;
import it.gniado.onwelo.service.VoterService;
import it.gniado.onwelo.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VotingController {

    private final VotingService votingService;

    private final CandidateService candidateService;
    private final VoterService voterService;

    public VotingController(VotingService votingService, CandidateService candidateService, VoterService voterService) {
        this.votingService = votingService;
        this.candidateService = candidateService;
        this.voterService = voterService;
    }

    @GetMapping("/")
    public String getVoting(Model model){
        List<Voter> voters = voterService.getAllVoters();
        List<Candidate> candidates = candidateService.getAllCandidates();
        model.addAttribute("voters", voters);
        model.addAttribute("candidates", candidates);
        return "voting";
    }

}
