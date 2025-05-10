package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;

public class ClassRoomEntityDTOMapper {
    public static ClassRoomDTO map(ClassRoomEntity classroomEntity) {
        ClassRoomDTO classroomDTO = new ClassRoomDTO();
        classroomDTO.setClassRoomId(classroomEntity.getClassRoomId());
        classroomDTO.setTitle(classroomEntity.getTitle());
        classroomDTO.setSessionFee(classroomEntity.getSessionFee());
        classroomDTO.setEnrolledStudentCount(classroomEntity.getEnrolledStudentCount());
        if (classroomEntity.getMentor() != null) {
            MentorDTO mentorDTO = MentorEntityDTOMapper.map(classroomEntity.getMentor());
            classroomDTO.setMentor(mentorDTO);
        }
        return classroomDTO;
    }

    public static ClassRoomEntity map(ClassRoomDTO classroomDTO) {
        ClassRoomEntity classroomEntity = new ClassRoomEntity();
        classroomEntity.setClassRoomId(classroomDTO.getClassRoomId());
        classroomEntity.setTitle(classroomDTO.getTitle());
        classroomEntity.setSessionFee(classroomDTO.getSessionFee());
        classroomEntity.setEnrolledStudentCount(classroomDTO.getEnrolledStudentCount());
        if (classroomDTO.getMentor() != null) {
            MentorEntity mentorEntity = MentorEntityDTOMapper.map(classroomDTO.getMentor());
            classroomEntity.setMentor(mentorEntity);
        }
        return classroomEntity;
    }
}
