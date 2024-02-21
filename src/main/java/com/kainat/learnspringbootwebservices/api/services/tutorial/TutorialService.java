package com.kainat.learnspringbootwebservices.api.services.tutorial;

import com.kainat.learnspringbootwebservices.api.dtos.TutorialDTO;
import com.kainat.learnspringbootwebservices.api.mappers.TutorialMapper;
import com.kainat.learnspringbootwebservices.exceptions.custom.DuplicateResourceException;
import com.kainat.learnspringbootwebservices.exceptions.custom.ResourceNotFoundException;
import com.kainat.learnspringbootwebservices.exceptions.messages.ExceptionMessage;
import com.kainat.learnspringbootwebservices.persistence.entities.CourseModule;
import com.kainat.learnspringbootwebservices.persistence.entities.Tutorial;
import com.kainat.learnspringbootwebservices.persistence.repositories.CourseModuleRepository;
import com.kainat.learnspringbootwebservices.persistence.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TutorialService implements ITutorialService{
    private final CourseModuleRepository courseModuleRepository;
    private final TutorialRepository tutorialRepository;
    private final TutorialMapper tutorialMapper;

    @Autowired
    public TutorialService(TutorialRepository tutorialRepository, TutorialMapper tutorialMapper, CourseModuleRepository courseModuleRepository) {
        this.tutorialRepository = tutorialRepository;
        this.tutorialMapper = tutorialMapper;
        this.courseModuleRepository = courseModuleRepository;
    }

    @Override
    public List<TutorialDTO> getTutorialsByModuleId(Integer courseId) {
        CourseModule courseModule = this.courseModuleRepository.findById(courseId).orElseThrow(()-> new ResourceNotFoundException(ExceptionMessage.COURSE_MODULE_NOT_FOUND + courseId));

        return this.tutorialMapper.toTutorialDTOs(this.tutorialRepository.getAllByCourseModule(courseModule));
    }

    @Override
    public TutorialDTO saveTutorial(TutorialDTO tutorialDTO) {
        this.checkForDuplicateTutorial(tutorialDTO);

        Tutorial savedTutorial = this.tutorialRepository.save(this.tutorialMapper.toTutorial(tutorialDTO));

        return this.tutorialMapper.toTutorialDTO(savedTutorial);
    }

    @Override
    @Transactional
    public List<TutorialDTO> saveTutorials(List<TutorialDTO> tutorialDTOs) {
        tutorialDTOs.forEach(this::checkForDuplicateTutorial);

        List<Tutorial> savedTutorials = this.tutorialRepository.saveAll(this.tutorialMapper.toTutorials(tutorialDTOs));
        return this.tutorialMapper.toTutorialDTOs(savedTutorials);
    }

    @Override
    public void deleteTutorialById(Integer id) {
        if (!this.tutorialRepository.existsById(id)) {
            throw new ResourceNotFoundException(ExceptionMessage.TUTORIAL_NOT_FOUND + id);
        }

        this.tutorialRepository.deleteById(id);

    }

    private void checkForDuplicateTutorial(TutorialDTO tutorialDTO) {
        if (this.tutorialRepository.existsByTitle(tutorialDTO.getTitle())) {
            throw new DuplicateResourceException(ExceptionMessage.TUTORIAL_ALREADY_EXISTS_WITH_TITLE + tutorialDTO.getTitle());
        } else if (this.tutorialRepository.existsByNumber(tutorialDTO.getNumber())) {
            throw new DuplicateResourceException(ExceptionMessage.TUTORIAL_ALREADY_EXISTS_WITH_NUMBER + tutorialDTO.getNumber());
        }
    }
}
