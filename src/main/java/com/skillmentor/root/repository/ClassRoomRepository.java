package com.skillmentor.root.repository;

import com.skillmentor.root.dto.ClassRoomDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ClassRoomRepository {
    private List<ClassRoomDTO> classRooms = new ArrayList<>();

    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        classRooms.add(classRoomDTO);
        return classRoomDTO;
    }

    public List<ClassRoomDTO> getAllClassRooms() {
        return new ArrayList<>(classRooms);
    }

    public ClassRoomDTO getClassRoomById(Integer id) {
        Optional<ClassRoomDTO> classRoomDTOOptional = classRooms.stream()
                .filter(classRoom -> Objects.equals(classRoom.getClassRoomId(), id))
                .findFirst();
        return classRoomDTOOptional.orElse(null);
    }

    public ClassRoomDTO updateClassRoomById(ClassRoomDTO classRoomDTO) {
        Optional<ClassRoomDTO> classRoomDTOOptional = classRooms.stream()
                .filter(classRoom -> Objects.equals(classRoom.getClassRoomId(), classRoomDTO.getClassRoomId()))
                .findFirst();
        ClassRoomDTO updatedClassRoom = classRoomDTOOptional.orElse(null);
        if (updatedClassRoom != null) {
            updatedClassRoom.setTitle(classRoomDTO.getTitle());
            updatedClassRoom.setSessionFee(classRoomDTO.getSessionFee());
        }
        return updatedClassRoom;
    }

    public ClassRoomDTO deleteClassRoomById(Integer id) {
        ClassRoomDTO classRoomDTO = getClassRoomById(id);
        if (classRoomDTO != null) {
            classRooms.remove(classRoomDTO);
        }
        return classRoomDTO;
    }
}