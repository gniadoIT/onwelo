package it.gniado.onwelo.controller;

import it.gniado.onwelo.exception.SaveInterruptedException;
import it.gniado.onwelo.exception.SaveInterruptedException.Sort;
import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.service.CandidateService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.rmi.ServerException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping(path = "/candidate")
    public ResponseEntity<HttpHeaders> addCandidate(@RequestParam("candidateName") String candidateName, HttpServletRequest servletRequest) throws ServerException {
        Candidate candidate = candidateService.addCandidate(candidateName);
        if (candidate == null){
            throw new SaveInterruptedException("An error occurred when creating Candidate", Sort.CANDIDATE);
        }
        servletRequest.getSession().removeAttribute("Sort");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/");
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }
}
