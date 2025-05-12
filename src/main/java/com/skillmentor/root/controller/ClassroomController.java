package com.skillmentor.root.controller;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/classroom")
public class ClassroomController {

    @Autowired
    private ClassRoomService classroomService;

    @PostMapping()
    public ResponseEntity<ClassRoomDTO> createClassroom(@RequestBody ClassRoomDTO classroomDTO) {
        ClassRoomDTO savedDTO = classroomService.createClassRoom(classroomDTO);
        return new ResponseEntity<>(savedDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ClassRoomDTO>> getAllClassrooms() {
        List<ClassRoomDTO> classroomDTOS = classroomService.getAllClassRooms();
        return new ResponseEntity<>(classroomDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoomDTO> findClassroomById(@PathVariable Integer id) {
        ClassRoomDTO classroom = classroomService.findClassRoomById(id);
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ClassRoomDTO> updateClassroom(@RequestBody ClassRoomDTO classroomDTO) {
        ClassRoomDTO classroom = classroomService.updateClassRoom(classroomDTO);
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassRoomDTO> deleteClassroom(@PathVariable Integer id) {
        ClassRoomDTO classroom = classroomService.deleteClassRoomById(id);
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }
}
