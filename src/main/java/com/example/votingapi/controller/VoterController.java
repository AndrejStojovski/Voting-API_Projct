package com.example.votingapi.controller;

import com.example.votingapi.model.Voter;
import com.example.votingapi.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voters")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @GetMapping
    public List<Voter> getAllVoters() {
        return voterService.getAllVoters();
    }

    @PostMapping
    public Voter createVoter(@RequestBody Voter voter) {
        return voterService.createVoter(voter);
    }

    @DeleteMapping("/{id}")
    public void deleteVoter(@PathVariable Long id) {
        voterService.deleteVoter(id);
    }
}
