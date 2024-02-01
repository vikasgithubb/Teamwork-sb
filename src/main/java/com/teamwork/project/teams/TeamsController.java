package com.teamwork.project.teams;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamsController {
    @Autowired
    TeamsService teamsService;



    @GetMapping("/teamup")
    public List<teams> getAllTeams() {
        return teamsService.getAllTeams();
    }

    @GetMapping("/teamlist/{email}")
    public List<teams> getteamnames(@PathVariable String email){
        return teamsService.getteamnames(email);
    }
}

