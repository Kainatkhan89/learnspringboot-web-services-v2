package com.kainat.learnspringbootwebservices.persistence.repositories;

import com.kainat.learnspringbootwebservices.persistence.entities.CourseModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseModuleRepository extends JpaRepository<CourseModule, Integer> {
    boolean existsByTitle(String title);
    boolean existsByNumber(Integer number);
    @Query("SELECT cm FROM CourseModule cm LEFT JOIN FETCH cm.tutorials")
    List<CourseModule> findAllAndTheirTutorials();
}