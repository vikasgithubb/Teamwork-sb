package com.teamwork.project.teams;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamsRepository extends JpaRepository<teams, Integer> {
    // You can add custom query methods if needed

    @Query(value = "SELECT T.TEAMID, T.TEAMNAME, T.DESCRIPTION FROM USER U JOIN TEAMMATES TM ON U.ID = TM.ID JOIN TEAMS T ON TM.TEAMID = T.TEAMID WHERE U.EMAIL = :email",nativeQuery = true)
    List<teams> findTeamsByUserEmail(String email);
}

