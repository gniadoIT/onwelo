package it.gniado.onwelo.controller;

import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.service.VoterService;
import org.apache.catalina.Server;
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
public class VoterController {

    private final VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @PostMapping(path = "voter", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Voter> addVoter(@RequestBody String voterName) throws ServerException {
        Voter voter = voterService.addVoter(voterName);
        if (voter == null){
            throw new ServerException("An error occurred when creating Voter.");
        }
        return new ResponseEntity<>(voter, HttpStatus.CREATED);
    }
}
