package com.kainat.learnspringbootwebservices.persistence.repositories;

import com.kainat.learnspringbootwebservices.persistence.entities.CourseModule;
import com.kainat.learnspringbootwebservices.persistence.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
    boolean existsByTitle(String title);
    boolean existsByNumber(Integer number);
    List<Tutorial> getAllByCourseModule(CourseModule courseModule);
}
