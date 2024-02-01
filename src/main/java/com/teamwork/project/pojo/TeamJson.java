package com.teamwork.project.pojo;

import lombok.Data;

import java.util.List;

@Data
public class TeamJson {

    private TeamDto team;

    @Data
    public static class TeamDto {
        private Integer teamid;
        private String teamname;
        private String description;
        private List<TeammateJson> teammates;
    }

    @Data
    public static class TeammateJson {
        private Long id;
        private Long teamid;
    }
}
