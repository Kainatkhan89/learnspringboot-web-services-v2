package com.kainat.learnspringbootwebservices.api.mappers;

import com.kainat.learnspringbootwebservices.api.dtos.TutorialDTO;
import com.kainat.learnspringbootwebservices.api.exceptions.custom.ResourceNotFoundException;
import com.kainat.learnspringbootwebservices.api.exceptions.messages.ExceptionMessage;
import com.kainat.learnspringbootwebservices.api.persistence.entities.CourseModule;
import com.kainat.learnspringbootwebservices.api.persistence.entities.Tutorial;
import com.kainat.learnspringbootwebservices.api.persistence.repositories.CourseModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialMapper {
    private final CourseModuleRepository courseModuleRepository;

    @Autowired
    public TutorialMapper(CourseModuleRepository courseModuleRepository) {
        this.courseModuleRepository = courseModuleRepository;
    }

    public Tutorial toTutorial(TutorialDTO tutorialDTO) {
        Tutorial tutorial = new Tutorial();

        tutorial.setNumber(tutorialDTO.getNumber());
        tutorial.setTitle(tutorialDTO.getTitle());
        tutorial.setDurationSeconds(tutorialDTO.getDurationSeconds());
        tutorial.setVideoUrl(tutorialDTO.getVideoUrl());
        tutorial.setStarterCodeUrl(tutorialDTO.getStarterCodeUrl());
        tutorial.setFinishedCodeUrl(tutorialDTO.getFinishedCodeUrl());

        CourseModule courseModule = this.courseModuleRepository.findById(tutorialDTO.getModuleId()).orElseThrow(() -> new ResourceNotFoundException(ExceptionMessage.COURSE_MODULE_NOT_FOUND + tutorialDTO.getModuleId()));

        tutorial.setCourseModule(courseModule);

        return tutorial;
    }

    public TutorialDTO toTutorialDTO(Tutorial tutorial) {
        TutorialDTO tutorialDTO = new TutorialDTO();

        tutorialDTO.setId(tutorial.getId());
        tutorialDTO.setModuleId(tutorial.getCourseModule().getId());
        tutorialDTO.setNumber(tutorial.getNumber());
        tutorialDTO.setTitle(tutorial.getTitle());
        tutorialDTO.setDurationSeconds(tutorial.getDurationSeconds());
        tutorialDTO.setVideoUrl(tutorial.getVideoUrl());
        tutorialDTO.setStarterCodeUrl(tutorial.getStarterCodeUrl());
        tutorialDTO.setFinishedCodeUrl(tutorial.getFinishedCodeUrl());

        return tutorialDTO;
    }
}
