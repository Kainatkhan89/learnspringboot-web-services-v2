package com.kainat.learnspringbootwebservices.api.mappers;

import com.kainat.learnspringbootwebservices.api.dtos.CourseModuleDTO;
import com.kainat.learnspringbootwebservices.api.dtos.CourseModulesDTO;
import com.kainat.learnspringbootwebservices.api.dtos.TutorialDTO;
import com.kainat.learnspringbootwebservices.api.persistence.entities.CourseModule;
import com.kainat.learnspringbootwebservices.api.enums.Color;
import com.kainat.learnspringbootwebservices.api.enums.Icon;
import org.hibernate.Hibernate;

import java.util.List;

public class CourseModuleMapper {
    private final TutorialMapper tutorialMapper;

    public CourseModuleMapper(TutorialMapper tutorialMapper) {
        this.tutorialMapper = tutorialMapper;
    }

    public CourseModule toCourseModule(CourseModuleDTO courseModuleDTO) {
        CourseModule courseModule = new CourseModule();

        courseModule.setNumber(courseModuleDTO.getNumber());
        courseModule.setTitle(courseModuleDTO.getTitle());
        courseModule.setDescription(courseModuleDTO.getDescription());
        courseModule.setIcon(Icon.valueOf(courseModuleDTO.getIcon()));
        courseModule.setColor(Color.valueOf(courseModuleDTO.getColor()));

        return courseModule;
    }

    public CourseModuleDTO toCourseModuleDTO(CourseModule courseModule) {
        CourseModuleDTO courseModuleDTO = new CourseModuleDTO();

        courseModuleDTO.setId(courseModule.getId());
        courseModuleDTO.setNumber(courseModule.getNumber());
        courseModuleDTO.setTitle(courseModule.getTitle());
        courseModuleDTO.setDescription(courseModule.getDescription());
        courseModuleDTO.setIcon(courseModule.getIcon().toString());
        courseModuleDTO.setColor(courseModule.getColor().toString());

        if (Hibernate.isInitialized(courseModule.getTutorials())) {
            List<TutorialDTO> tutorialDTOs = courseModule.getTutorials().stream().map(this.tutorialMapper::toTutorialDTO).toList();
            courseModuleDTO.setTutorials(tutorialDTOs);
        }

        return courseModuleDTO;
    }

    public CourseModulesDTO toCourseModulesDTO(List<CourseModule> courseModules) {
        CourseModulesDTO courseModulesDTO = new CourseModulesDTO();

        List<CourseModuleDTO> courseModuleDTOList = courseModules.stream().map(this::toCourseModuleDTO).toList();
        courseModulesDTO.setModules(courseModuleDTOList);

        return courseModulesDTO;
    }

}
