package com.skillmentor.root.controller;


import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @PostMapping()
    public ResponseEntity<MentorDTO> createMentor(@RequestBody MentorDTO mentorDTO) {
        MentorDTO savedDTO = mentorService.createMentor(mentorDTO);
        return new ResponseEntity<>(savedDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<MentorDTO>> getAllMentors(
        @RequestParam(required = false) List<String> firstNames,
        @RequestParam(required = false) List<String>  subjects) {
    List<MentorDTO> mentorDTOS = mentorService.getAllMentors(firstNames, subjects);
    return new ResponseEntity<>(mentorDTOS, HttpStatus.OK);
}

    @GetMapping("/{id}")
    public ResponseEntity<MentorDTO> findMentorById(@PathVariable Integer id) {
        MentorDTO mentor = mentorService.getMentorById(id);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<MentorDTO> updateMentor(@RequestBody MentorDTO mentorDTO) {
        MentorDTO mentor = mentorService.updateMentorById(mentorDTO);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MentorDTO> deleteMentor(@PathVariable Integer id) {
        MentorDTO mentor = mentorService.deleteMentorById(id);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }
}
