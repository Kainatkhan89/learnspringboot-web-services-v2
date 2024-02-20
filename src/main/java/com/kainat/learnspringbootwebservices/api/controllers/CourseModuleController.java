package com.kainat.learnspringbootwebservices.api.controllers;

import com.kainat.learnspringbootwebservices.api.dtos.CourseModuleDTO;
import com.kainat.learnspringbootwebservices.api.dtos.CourseModulesDTO;
import com.kainat.learnspringbootwebservices.api.services.coursemodule.CourseModuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/course-modules")
public class CourseModuleController {
    private final CourseModuleService courseModuleService;
    @Autowired
    public CourseModuleController(CourseModuleService courseModuleService) {
        this.courseModuleService = courseModuleService;
    }

    @GetMapping
    public ResponseEntity<CourseModulesDTO> getAllCourseModules() {
        CourseModulesDTO courseModulesDTO = this.courseModuleService.getAllCourseModules();
        return ResponseEntity.ok(courseModulesDTO);
    }

    @GetMapping("/with-tutorials")
    public ResponseEntity<CourseModulesDTO> getAllCourseModulesAndTheirTutorials() {
        CourseModulesDTO courseModulesDTO = this.courseModuleService.getAllCourseModulesAndTheirTutorials();
        return ResponseEntity.ok(courseModulesDTO);
    }

    @PostMapping
    public ResponseEntity<CourseModuleDTO> createCourseModule(@Valid @RequestBody CourseModuleDTO courseModuleDTO) {
        CourseModuleDTO savedCourseModuleDTO = this.courseModuleService.saveCourseModule(courseModuleDTO);
        return new ResponseEntity<>(savedCourseModuleDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseModuleDTO> getCourseModuleById(@PathVariable Integer id) {
        CourseModuleDTO courseModuleDTO = this.courseModuleService.getCourseModuleById(id);
        return ResponseEntity.ok(courseModuleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseModuleById(@PathVariable Integer id) {
        this.courseModuleService.deleteCourseModuleById(id);
        return ResponseEntity.ok().build();
    }
}
