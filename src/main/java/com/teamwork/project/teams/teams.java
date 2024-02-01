package com.teamwork.project.teams;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class teams {

    @Id
    private Integer teamid;

    private String teamname;

    private String description;

    @OneToMany(mappedBy = "teams")
    private List<teammates> teammates;


}
