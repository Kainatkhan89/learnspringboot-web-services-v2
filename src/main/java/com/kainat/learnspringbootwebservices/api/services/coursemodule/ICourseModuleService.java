package com.kainat.learnspringbootwebservices.api.services.coursemodule;

import com.kainat.learnspringbootwebservices.api.dtos.CourseModuleDTO;
import com.kainat.learnspringbootwebservices.api.dtos.CourseModulesDTO;

public interface ICourseModuleService {
    CourseModuleDTO saveCourseModule(CourseModuleDTO courseModuleDTO);
    CourseModuleDTO getCourseModuleById(Integer id);
    void deleteCourseModuleById(Integer id);
    CourseModulesDTO getAllCourseModules();
    CourseModulesDTO getAllCourseModulesAndTheirTutorials();

}
