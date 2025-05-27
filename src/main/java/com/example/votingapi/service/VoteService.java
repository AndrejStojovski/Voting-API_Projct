package com.example.votingapi.service;

import com.example.votingapi.model.Vote;
import com.example.votingapi.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Vote castVote(Vote vote) {
        return voteRepository.save(vote);
    }
}
