package it.gniado.onwelo.controller;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VotingController {

    private final VotingService votingService;

    public VotingController(VotingService votingService) {
        this.votingService = votingService;
    }


    @GetMapping("/")
    public String getVoting(Model model){
        List<Voter> voters = votingService.getAllVoters();
        List<Candidate> candidates = votingService.getAllCandidates();
        model.addAttribute("voters", voters);
        model.addAttribute("candidates", candidates);
        return "voting";
    }

}
