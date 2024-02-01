package com.teamwork.project.teams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeammateRepository extends JpaRepository<teammates, TeammatesId> {
    // Additional query methods if needed
}
