package com.kainat.learnspringbootwebservices.api.services.tutorial;

import com.kainat.learnspringbootwebservices.api.dtos.TutorialDTO;

import java.util.List;

public interface ITutorialService {

    List<TutorialDTO> getTutorialsByModuleId(Integer courseId);
    TutorialDTO saveTutorial(TutorialDTO tutorialDTO);
    List<TutorialDTO> saveTutorials(List<TutorialDTO> tutorialDTOs);
    void deleteTutorialById(Integer id);
}
