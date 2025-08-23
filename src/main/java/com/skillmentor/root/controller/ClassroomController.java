package com.skillmentor.root.controller;

import com.skillmentor.root.common.Constants;
import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.service.ClassRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/academic")
@Tag(name = "Classroom Management", description = "Endpoints for managing classrooms and their relationships")
public class ClassroomController {

    @Autowired
    private ClassRoomService classroomService;

    public ClassroomController() {
    }

    @Operation(summary = "Create a new classroom", description = "Creates a new classroom along with its mentor(s)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classroom successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize(Constants.ADMIN_ROLE_PERMISSION)
    @PostMapping(value = "/classroom", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> createClassroom(
            @Parameter(description = "Classroom details to create", required = true)
            @Valid @RequestBody ClassRoomDTO classroomDTO) {
        final ClassRoomDTO savedDTO = classroomService.createClassRoom(classroomDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @Operation(summary = "Get all classrooms", description = "Fetches a list of all classrooms with associated data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classroom list retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No classrooms found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize(Constants.ADMIN_ROLE_PERMISSION)
    @GetMapping(value = "/classroom", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<List<ClassRoomDTO>> getAllClassrooms() {
        final List<ClassRoomDTO> classroomDTOS = classroomService.getAllClassRooms();
        return ResponseEntity.ok(classroomDTOS);
    }

    @Operation(summary = "Get classroom by ID", description = "Fetches a classroom using its unique identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classroom retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid ID"),
            @ApiResponse(responseCode = "404", description = "Classroom not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize(Constants.ADMIN_ROLE_PERMISSION)
    @GetMapping(value = "/classroom/{id}", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> findClassroomById(
            @Parameter(description = "ID of the classroom to retrieve", required = true)
            @PathVariable @Min(value = 1, message = "Classroom ID must be positive") Integer id) {
        final ClassRoomDTO classroom = classroomService.findClassRoomById(id);
        return ResponseEntity.ok(classroom);
    }

    @Operation(summary = "Update classroom", description = "Updates an existing classroom's details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classroom updated successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid data"),
            @ApiResponse(responseCode = "404", description = "Classroom not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize(Constants.ADMIN_ROLE_PERMISSION)
    @PutMapping(value = "/classroom", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> updateClassroom(
            @Parameter(description = "Classroom details to update", required = true)
            @Valid @RequestBody ClassRoomDTO classroomDTO) {
        final ClassRoomDTO classroom = classroomService.updateClassRoom(classroomDTO);
        return ResponseEntity.ok(classroom);
    }

    @Operation(summary = "Delete classroom by ID", description = "Deletes a classroom and its associated data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classroom deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid ID"),
            @ApiResponse(responseCode = "404", description = "Classroom not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize(Constants.ADMIN_ROLE_PERMISSION)
    @DeleteMapping(value = "/classroom/{id}", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> deleteClassroom(
            @Parameter(description = "ID of the classroom to delete", required = true)
            @PathVariable @Min(value = 1, message = "Classroom ID must be positive") Integer id) {
        final ClassRoomDTO classroom = classroomService.deleteClassRoomById(id);
        return ResponseEntity.ok(classroom);
    }
}
