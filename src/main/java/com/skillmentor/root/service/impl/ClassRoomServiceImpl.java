package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.repository.ClassRoomRepository;
import com.skillmentor.root.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoomDTO> getAllClassRooms() {
        return classRoomRepository.getAllClassRooms();
    }

    @Override
    public ClassRoomDTO findClassRoomById(Integer id) {
        ClassRoomDTO classRoomDTO = classRoomRepository.getClassRoomById(id);
        if (classRoomDTO == null) {
            throw new RuntimeException("ClassRoom not found");
        }
        return classRoomDTO;
    }

    @Override
    public ClassRoomDTO deleteClassRoomById(Integer id) {
        ClassRoomDTO classRoomDTO = classRoomRepository.deleteClassRoomById(id);
        return classRoomDTO;
    }

    @Override
    public ClassRoomDTO updateClassRoom(ClassRoomDTO classRoomDTO) {
        ClassRoomDTO classRoom = classRoomRepository.updateClassRoomById(classRoomDTO);
        if (classRoom == null) {
            throw new RuntimeException("ClassRoom not found");
        }
        return classRoom;
    }

    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        return classRoomRepository.createClassRoom(classRoomDTO);
    }
}