package com.teamwork.project.teams;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teammates")
@CrossOrigin(origins = "http://localhost:4200")
public class TeammateController {

    private final TeammateService teammateService;

    @Autowired
    public TeammateController(TeammateService teammateService) {
        this.teammateService = teammateService;
    }

    @GetMapping("/teaminfo")
    public ResponseEntity<List<teammates>> getAllTeammates() {
        List<teammates> teammates = teammateService.getAllTeammates();

        if (!teammates.isEmpty()) {
            return new ResponseEntity<>(teammates, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTeamAndTeammates(@RequestBody String jsonString) {
        try {
            teammateService.saveTeamAndTeammates(jsonString);
            return ResponseEntity.ok("Team and teammates saved successfully");
        } catch (Exception e) {
            // Handle exceptions or return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving team and teammates");
        }
    }

}

