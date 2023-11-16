package it.gniado.onwelo.cfg;

import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.repository.CandidateRepository;
import it.gniado.onwelo.repository.VoterRepository;
import it.gniado.onwelo.service.VotingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CandidateRepository candidateRepository(){
        return new CandidateRepository();
    }

    @Bean
    public VoterRepository voterRepository(){
        return new VoterRepository();
    }

}
