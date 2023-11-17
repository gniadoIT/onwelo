package it.gniado.onwelo.controller;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.rmi.ServerException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping(path = "candidate", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidate> addCandidate(@RequestBody String candidateName) throws ServerException {
        Candidate candidate = candidateService.addCandidate(candidateName);
        if (candidate == null){
            throw new ServerException("An error occurred when creating Candidate");
        }
        return new ResponseEntity<>(candidate, HttpStatus.CREATED);
    }
}
