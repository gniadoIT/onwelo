package it.gniado.onwelo.controller;

import it.gniado.onwelo.exception.SaveInterruptedException;
import it.gniado.onwelo.exception.SaveInterruptedException.Sort;
import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.service.VoterService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.rmi.ServerException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class VoterController {

    private final VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @PostMapping(path = "/voter")
    public ResponseEntity<HttpHeaders> addVoter(@RequestParam("voterName") String voterName, HttpServletRequest servletRequest) throws ServerException {
        Voter voter = voterService.addVoter(voterName);
        if (voter == null){
            throw new SaveInterruptedException("An error occurred when creating Voter.", Sort.VOTER);
        }
        servletRequest.getSession().removeAttribute("Sort");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/");
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }
}
