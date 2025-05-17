package com.skillmentor.root.controller;

import com.skillmentor.root.common.Constants;
import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.service.MentorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/academic")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    public MentorController() {
    }

    @PostMapping(value = "/mentor", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
    public ResponseEntity<MentorDTO> createMentor(@Valid @RequestBody MentorDTO mentorDTO) {
        final MentorDTO savedDTO = mentorService.createMentor(mentorDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping(value = "/mentor", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<List<MentorDTO>> getAllMentors(@RequestParam(required = false) List<String> firstNames, @RequestParam(required = false) List<String> subjects) {
        final List<MentorDTO> mentorDTOS = mentorService.getAllMentors(firstNames, subjects);
        return ResponseEntity.ok(mentorDTOS);
    }

    @GetMapping(value = "/mentor/{id}", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<MentorDTO> findMentorById(@PathVariable @Min(value = 1, message = "Mentor ID must be a positive integer") Integer id) {
        final MentorDTO mentor = mentorService.findMentorById(id);
        return ResponseEntity.ok(mentor);
    }

    @PutMapping(value = "/mentor", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
    public ResponseEntity<MentorDTO> updateMentor(@Valid @RequestBody MentorDTO mentorDTO) {
        final MentorDTO mentor = mentorService.updateMentorById(mentorDTO);
        return ResponseEntity.ok(mentor);
    }

    @DeleteMapping(value = "/mentor/{id}", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<MentorDTO> deleteMentor(@PathVariable @Min(value = 1, message = "Mentor ID must be a positive integer") Integer id) {
        final MentorDTO mentor = mentorService.deleteMentorById(id);
        return ResponseEntity.ok(mentor);
    }
}
