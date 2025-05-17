package com.skillmentor.root.controller;

import com.skillmentor.root.common.Constants;
import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.service.ClassRoomService;
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
public class ClassroomController {

    @Autowired
    private ClassRoomService classroomService;

    public ClassroomController() {
    }

    @PostMapping(value = "/classroom", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> createClassroom(@Valid @RequestBody ClassRoomDTO classroomDTO) {
        final ClassRoomDTO savedDTO = classroomService.createClassRoom(classroomDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping(value = "/classroom", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<List<ClassRoomDTO>> getAllClassrooms() {
        final List<ClassRoomDTO> classroomDTOS = classroomService.getAllClassRooms();
        return ResponseEntity.ok(classroomDTOS);
    }

    @GetMapping(value = "/classroom/{id}", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> findClassroomById(@PathVariable @Min(value = 1, message = "Classroom ID must be positive") Integer id) {
        final ClassRoomDTO classroom = classroomService.findClassRoomById(id);
        return ResponseEntity.ok(classroom);
    }

    @PutMapping(value = "/classroom", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> updateClassroom(@Valid @RequestBody ClassRoomDTO classroomDTO) {
        final ClassRoomDTO classroom = classroomService.updateClassRoom(classroomDTO);
        return ResponseEntity.ok(classroom);
    }

    @DeleteMapping(value = "/classroom/{id}", produces = Constants.APPLICATION_JSON)
    public ResponseEntity<ClassRoomDTO> deleteClassroom(@PathVariable @Min(value = 1, message = "Classroom ID must be positive") Integer id) {
        final ClassRoomDTO classroom = classroomService.deleteClassRoomById(id);
        return ResponseEntity.ok(classroom);
    }
}
