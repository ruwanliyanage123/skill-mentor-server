package com.skillmentor.root.controller;

import com.skillmentor.root.common.Constants;
import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.exception.MentorException;
import com.skillmentor.root.service.MentorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/academic")
@Tag(name = "Mentor Management", description = "Endpoints for managing mentors and their related data")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    public MentorController() {}

    @Operation(summary = "Create a new mentor", description = "Creates a mentor along with subject and classroom associations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mentor created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid mentor data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize(Constants.ADMIN_ROLE_PERMISSION)
    @PostMapping(value = "/mentor", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
    public ResponseEntity<?> createMentor(
            @Parameter(description = "Mentor details to be created", required = true)
            @Valid @RequestBody MentorDTO mentorDTO) {
        try {
            final MentorDTO savedDTO = mentorService.createMentor(mentorDTO);
            return ResponseEntity.ok(savedDTO);
        } catch (MentorException mentorException) {
            return ResponseEntity.badRequest().body(mentorException.getMessage());
        }
    }

    @Operation(summary = "Get all mentors", description = "Retrieves all mentors with optional filtering by name or subject")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mentors retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No mentors found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize(Constants.ADMIN_ROLE_PERMISSION)
    @GetMapping(value = "/mentor", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<List<MentorDTO>> getAllMentors(
            @Parameter(description = "Filter by mentor first name") @RequestParam(required = false) List<String> firstNames,
            @Parameter(description = "Filter by subject specialization") @RequestParam(required = false) List<String> subjects) {
        final List<MentorDTO> mentorDTOS = mentorService.getAllMentors(firstNames, subjects);
        return ResponseEntity.ok(mentorDTOS);
    }

    @Operation(summary = "Get mentor by ID", description = "Retrieves a single mentor using their unique ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mentor retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid mentor ID"),
            @ApiResponse(responseCode = "404", description = "Mentor not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize(Constants.ADMIN_ROLE_PERMISSION)
    @GetMapping(value = "/mentor/{id}", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<?> findMentorById(
            @Parameter(description = "ID of the mentor to retrieve", required = true)
            @PathVariable @Min(value = 1, message = "Mentor ID must be a positive integer") Integer id) {
        try {
            final MentorDTO mentor = mentorService.findMentorById(id);
            return ResponseEntity.ok(mentor);
        } catch (MentorException mentorException) {
            return ResponseEntity.badRequest().body(mentorException.getMessage());
        }
    }

    @Operation(summary = "Update a mentor", description = "Updates an existing mentor's details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mentor updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid mentor data"),
            @ApiResponse(responseCode = "404", description = "Mentor not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize(Constants.ADMIN_ROLE_PERMISSION)
    @PutMapping(value = "/mentor", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
    public ResponseEntity<?> updateMentor(
            @Parameter(description = "Mentor details to update", required = true)
            @Valid @RequestBody MentorDTO mentorDTO) {
        try {
            final MentorDTO mentor = mentorService.updateMentorById(mentorDTO);
            return ResponseEntity.ok(mentor);
        } catch (MentorException mentorException) {
            return new ResponseEntity<>(mentorException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete mentor by ID", description = "Deletes a mentor by their unique identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mentor deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid mentor ID"),
            @ApiResponse(responseCode = "404", description = "Mentor not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping(value = "/mentor/{id}", produces = Constants.APPLICATION_JSON)
    @PreAuthorize(Constants.ADMIN_ROLE_PERMISSION)
    public ResponseEntity<?> deleteMentor(
            @Parameter(description = "ID of the mentor to delete", required = true)
            @PathVariable @Min(value = 1, message = "Mentor ID must be a positive integer") Integer id) {
        try {
            final MentorDTO mentor = mentorService.deleteMentorById(id);
            return ResponseEntity.ok(mentor);
        } catch (MentorException mentorException) {
            return ResponseEntity.badRequest().body(mentorException.getMessage());
        }
    }
}
