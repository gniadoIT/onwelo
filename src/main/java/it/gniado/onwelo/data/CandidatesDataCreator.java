package it.gniado.onwelo.data;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Figure;
import it.gniado.onwelo.repository.CandidateRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CandidatesDataCreator implements ApplicationListener<ContextRefreshedEvent> {

    private static final String MICKEY = "Mickey";
    private static final String DONALD = "Donald";
    private static final String DAISY = "Daisy";
    private static final String GOOFY = "Goofy";
    private static final String MINNIE = "Minnie";
    private static final String CLARABELLE = "Clarabelle";
    private static final String PLUTO = "Pluto";
    private static final String PETE = "Pete";

    private final CandidateRepository candidateRepository;

    public CandidatesDataCreator(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    private void initData() {
        List<Candidate> candidates = List.of(
                new Candidate(new Figure(MICKEY)),
                new Candidate(new Figure(DONALD)),
                new Candidate(new Figure(DAISY)),
                new Candidate(new Figure(GOOFY)),
                new Candidate(new Figure(MINNIE)),
                new Candidate(new Figure(CLARABELLE)),
                new Candidate(new Figure(PLUTO)),
                new Candidate(new Figure(PETE))
        );
        candidateRepository.addCandidates(candidates);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
