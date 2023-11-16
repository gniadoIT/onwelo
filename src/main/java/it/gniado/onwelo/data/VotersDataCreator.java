package it.gniado.onwelo.data;

import it.gniado.onwelo.model.Figure;
import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VotersDataCreator implements ApplicationListener<ContextRefreshedEvent> {

    private static final String BUGS = "Bugs";
    private static final String DAFFY = "Daffy";
    private static final String SYLVESTER = "Sylvester";
    private static final String TWEETY = "Tweety";
    private static final String PORKY = "Porky";
    private static final String SPEEDY = "Speedy";
    private static final String LOLA = "Lola";

    private final VoterRepository voterRepository;

    public VotersDataCreator(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    private void initData() {
        List<Voter> voters = List.of(
                new Voter(new Figure(BUGS)),
                new Voter(new Figure(DAFFY)),
                new Voter(new Figure(SYLVESTER)),
                new Voter(new Figure(TWEETY)),
                new Voter(new Figure(PORKY)),
                new Voter(new Figure(SPEEDY)),
                new Voter(new Figure(LOLA))
        );
        voterRepository.addVoters(voters);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
