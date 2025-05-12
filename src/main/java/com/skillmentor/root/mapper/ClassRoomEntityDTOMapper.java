package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.entity.ClassRoomEntity;

public class ClassRoomEntityDTOMapper {
    public static ClassRoomDTO map(ClassRoomEntity classroomEntity) {
        ClassRoomDTO classroomDTO = new ClassRoomDTO();
        classroomDTO.setClassRoomId(classroomEntity.getClassRoomId());
        classroomDTO.setTitle(classroomEntity.getTitle());
        classroomDTO.setEnrolledStudentCount(classroomEntity.getEnrolledStudentCount());
        return classroomDTO;
    }

    public static ClassRoomEntity map(ClassRoomDTO classroomDTO) {
        ClassRoomEntity classroomEntity = new ClassRoomEntity();
        classroomEntity.setClassRoomId(classroomDTO.getClassRoomId());
        classroomEntity.setTitle(classroomDTO.getTitle());
        classroomEntity.setEnrolledStudentCount(classroomDTO.getEnrolledStudentCount());
        return classroomEntity;
    }
}
