package com.teamwork.project.teams;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamwork.project.pojo.TeamJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeammateService {

     @Autowired
     TeammateRepository teammateRepository;

     @Autowired
     TeamsRepository teamsRepository;





    public List<teammates> getAllTeammates() {
        return teammateRepository.findAll();
    }

    // Add other service methods as needed

    public void saveTeamAndTeammates(String jsonString) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TeamJson teamJson = objectMapper.readValue(jsonString, TeamJson.class);

        // Save Team
        teams teamEntity = teams.builder()
                .teamid(teamJson.getTeam().getTeamid())
                .teamname(teamJson.getTeam().getTeamname())
                .description(teamJson.getTeam().getDescription())
                .build();
        teamsRepository.save(teamEntity);

        // Save Teammates
        for (TeamJson.TeammateJson teammateJson : teamJson.getTeam().getTeammates()) {
            teammates teammatesEntity = teammates.builder()
                    .teamid(teammateJson.getTeamid())
                    .id(teammateJson.getId())
                    .build();
            teammateRepository.save(teammatesEntity);
        }
    }
}

