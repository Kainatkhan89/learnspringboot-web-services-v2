package com.kainat.learnspringbootwebservices.api.services.coursemodule;

import com.kainat.learnspringbootwebservices.api.dtos.CourseModuleDTO;
import com.kainat.learnspringbootwebservices.api.dtos.CourseModulesDTO;
import com.kainat.learnspringbootwebservices.exceptions.custom.DuplicateResourceException;
import com.kainat.learnspringbootwebservices.exceptions.custom.ResourceNotFoundException;
import com.kainat.learnspringbootwebservices.exceptions.messages.ExceptionMessage;
import com.kainat.learnspringbootwebservices.api.mappers.CourseModuleMapper;
import com.kainat.learnspringbootwebservices.persistence.entities.CourseModule;
import com.kainat.learnspringbootwebservices.persistence.repositories.CourseModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseModuleService implements ICourseModuleService {
    private final CourseModuleRepository courseModuleRepository;
    private final CourseModuleMapper courseModuleMapper;

    @Autowired
    CourseModuleService(CourseModuleRepository courseModuleRepository, CourseModuleMapper courseModuleMapper) {
        this.courseModuleRepository = courseModuleRepository;
        this.courseModuleMapper = courseModuleMapper;
    }

    @Override
    public CourseModuleDTO saveCourseModule(CourseModuleDTO courseModuleDTO) {
        this.checkForDuplicateCourseModule(courseModuleDTO);

        CourseModule courseModuleToSave = this.courseModuleMapper.toCourseModule(courseModuleDTO);
        CourseModule savedCourseModule = this.courseModuleRepository.save(courseModuleToSave);

        return this.courseModuleMapper.toCourseModuleDTO(savedCourseModule);
    }

    @Override
    public CourseModuleDTO getCourseModuleById(Integer id) {
        CourseModule courseModule = this.courseModuleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionMessage.COURSE_MODULE_NOT_FOUND + id));
        return this.courseModuleMapper.toCourseModuleDTO(courseModule);
    }

    @Override
    public void deleteCourseModuleById(Integer id) {
        if (!this.courseModuleRepository.existsById(id)) {
            throw new ResourceNotFoundException(ExceptionMessage.COURSE_MODULE_NOT_FOUND + id);
        }

        this.courseModuleRepository.deleteById(id);
    }

    @Override
    public CourseModulesDTO getAllCourseModules() {
        List<CourseModule> courseModules = this.courseModuleRepository.findAll();
        return this.courseModuleMapper.toCourseModulesDTO(courseModules);
    }

    @Override
    public CourseModulesDTO getAllCourseModulesAndTheirTutorials() {
        List<CourseModule> courseModules = this.courseModuleRepository.findAllAndTheirTutorials();
        return this.courseModuleMapper.toCourseModulesDTO(courseModules);
    }

    private void checkForDuplicateCourseModule(CourseModuleDTO courseModuleDTO) {
        if(this.courseModuleRepository.existsByTitle(courseModuleDTO.getTitle())) {
            throw new DuplicateResourceException(ExceptionMessage.COURSE_MODULE_ALREADY_EXISTS_WITH_TITLE + courseModuleDTO.getTitle());
        } else if (this.courseModuleRepository.existsByNumber(courseModuleDTO.getNumber())) {
            throw new DuplicateResourceException(ExceptionMessage.COURSE_MODULE_ALREADY_EXISTS_WITH_NUMBER + courseModuleDTO.getNumber());
        }
    }
}
