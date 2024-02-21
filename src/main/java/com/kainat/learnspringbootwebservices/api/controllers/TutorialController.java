package com.kainat.learnspringbootwebservices.api.controllers;

import com.kainat.learnspringbootwebservices.api.dtos.TutorialDTO;
import com.kainat.learnspringbootwebservices.api.services.tutorial.TutorialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tutorials")
public class TutorialController {
    private final TutorialService tutorialService;
    @Autowired
    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping("module-tutorials/{moduleId}")
    public ResponseEntity<List<TutorialDTO>> getTutorials(@PathVariable Integer moduleId) {
       List<TutorialDTO> tutorialDTOS = this.tutorialService.getTutorialsByModuleId(moduleId);
       return ResponseEntity.ok(tutorialDTOS);
    }

    @PostMapping("/create")
    public ResponseEntity<TutorialDTO> createTutorial(@Valid @RequestBody TutorialDTO tutorialDTO) {
        TutorialDTO savedTutorialDTO = this.tutorialService.saveTutorial(tutorialDTO);
        return new ResponseEntity<>(savedTutorialDTO, HttpStatus.CREATED);
    }

    @PostMapping("/create-all")
    public ResponseEntity<List<TutorialDTO>> createTutorials(@Valid @RequestBody List<TutorialDTO> tutorialDTOS) {
        List<TutorialDTO> savedTutorialDTOs = this.tutorialService.saveTutorials(tutorialDTOS);
        return new ResponseEntity<>(savedTutorialDTOs, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTutorialById(@PathVariable Integer id) {
        this.tutorialService.deleteTutorialById(id);
        return ResponseEntity.ok().build();
    }
}
