package com.kainat.learnspringbootwebservices.api.dtos;

import java.util.List;

public class CourseModulesDTO {
    private List<CourseModuleDTO> modules;

    public CourseModulesDTO() {
    }

    public List<CourseModuleDTO> getModules() {
        return this.modules;
    }

    public void setModules(List<CourseModuleDTO> modules) {
        this.modules = modules;
    }
}