package it.gniado.onwelo.controller;

import it.gniado.onwelo.exception.SaveInterruptedException;
import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.service.CandidateService;
import it.gniado.onwelo.service.VoterService;
import it.gniado.onwelo.service.VotingService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
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
    public String getVoting(Model model, @Nullable @SessionAttribute("Sort") String sort){
        List<Voter> voters = voterService.getAllVoters();
        List<Candidate> candidates = candidateService.getAllCandidates();
        model.addAttribute("voters", voters);
        model.addAttribute("candidates", candidates);
        model.addAttribute("sort", sort);
        return "voting";
    }

    @PostMapping("/vote")
    public ModelAndView vote(@RequestParam("voterId") int voterId, @RequestParam("candidateId") int candidateId){
        votingService.addVote(voterId, candidateId);
        return new ModelAndView("redirect:/");
    }

}
