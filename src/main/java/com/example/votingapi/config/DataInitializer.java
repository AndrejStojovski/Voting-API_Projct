package com.example.votingapi.config;

import com.example.votingapi.model.*;
import com.example.votingapi.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(
            VoterRepository voterRepo,
            ElectionRepository electionRepo,
            CandidateRepository candidateRepo,
            VoteRepository voteRepo
    ) {
        return args -> {
            // Create voters
            Voter alice = new Voter();
            alice.setName("Alice");

            Voter bob = new Voter();
            bob.setName("Bob");

            voterRepo.save(alice);
            voterRepo.save(bob);

            // Create an election
            Election election = new Election();
            election.setTitle("2025 Student Council");

            electionRepo.save(election);

            // Create candidates
            Candidate jane = new Candidate();
            jane.setName("Jane");
            jane.setElection(election);

            Candidate mark = new Candidate();
            mark.setName("Mark");
            mark.setElection(election);

            candidateRepo.save(jane);
            candidateRepo.save(mark);

            // Cast votes
            Vote vote1 = new Vote();
            vote1.setVoter(alice);
            vote1.setElection(election);
            vote1.setCandidate(jane);

            Vote vote2 = new Vote();
            vote2.setVoter(bob);
            vote2.setElection(election);
            vote2.setCandidate(mark);

            voteRepo.save(vote1);
            voteRepo.save(vote2);
        };
    }
}
