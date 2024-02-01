package com.teamwork.project.teams;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService {

    @Autowired
    TeamsRepository teamsRepository;


    public List<teams> getAllTeams() {
        return teamsRepository.findAll();
    }


    public List<teams> getteamnames(String email){
        return teamsRepository.findTeamsByUserEmail(email);
    }

    public teams getTeamById(Integer teamId) {
        return teamsRepository.findById(teamId).orElse(null);
    }

    public teams saveTeam(teams team) {
        return teamsRepository.save(team);
    }

    public void deleteTeam(Integer teamId) {
        teamsRepository.deleteById(teamId);
    }
}
