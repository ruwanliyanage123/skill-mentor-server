package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.SessionDTO;
import com.skillmentor.root.entity.SessionEntity;

public class SessionDTOEntityMapper {

    public static SessionEntity map(SessionDTO sessionDTO) {
        if (sessionDTO == null) {
            return null;
        }
        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity.setSessionId(sessionDTO.getSessionId());
        sessionEntity.setStudentEntity(StudentEntityDTOMapper.map(sessionDTO.getStudentDTO()));
        sessionEntity.setClassRoomEntity(ClassRoomEntityDTOMapper.map(sessionDTO.getClassRoomDTO()));
        sessionEntity.setMentorEntity(MentorEntityDTOMapper.map(sessionDTO.getMentorDTO()));
        sessionEntity.setTopic(sessionDTO.getTopic());
        sessionEntity.setStartTime(sessionDTO.getStartTime());
        sessionEntity.setEndTime(sessionDTO.getEndTime());
        return sessionEntity;
    }

    public static SessionDTO map(SessionEntity sessionEntity) {
        if (sessionEntity == null) {
            return null;
        }
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setSessionId(sessionEntity.getSessionId());
        sessionDTO.setStudentDTO(StudentEntityDTOMapper.map(sessionEntity.getStudentEntity()));
        sessionDTO.setClassRoomDTO(ClassRoomEntityDTOMapper.map(sessionEntity.getClassRoomEntity()));
        sessionDTO.setMentorDTO(MentorEntityDTOMapper.map(sessionEntity.getMentorEntity()));
        sessionDTO.setTopic(sessionEntity.getTopic());
        sessionDTO.setStartTime(sessionEntity.getStartTime());
        sessionDTO.setEndTime(sessionEntity.getEndTime());
        return sessionDTO;
    }
}