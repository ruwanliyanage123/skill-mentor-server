package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.AuditDTO;
import com.skillmentor.root.entity.SessionEntity;

public class AuditDTOEntityMapper {
    public static AuditDTO map(SessionEntity sessionEntity) {
        if (sessionEntity == null) {
            return null;
        }
        AuditDTO auditDTO = new AuditDTO();
        auditDTO.setSessionId(sessionEntity.getSessionId());
        auditDTO.setStudentId(sessionEntity.getStudentEntity().getStudentId());
        auditDTO.setStudentFirstName(sessionEntity.getStudentEntity().getFirstName());
        auditDTO.setStudentLastName(sessionEntity.getStudentEntity().getLastName());
        auditDTO.setStudentEmail(sessionEntity.getStudentEntity().getEmail());
        auditDTO.setStudentPhoneNumber(sessionEntity.getStudentEntity().getPhoneNumber());
        auditDTO.setClassTitle(sessionEntity.getClassRoomEntity().getTitle());
        auditDTO.setMentorId(sessionEntity.getMentorEntity().getMentorId());
        auditDTO.setMentorFirstName(sessionEntity.getMentorEntity().getFirstName());
        auditDTO.setMentorLastName(sessionEntity.getMentorEntity().getLastName());
        auditDTO.setMentorPhoneNumber(sessionEntity.getMentorEntity().getPhoneNumber());
        auditDTO.setStartTime(sessionEntity.getStartTime());
        auditDTO.setFee(sessionEntity.getMentorEntity().getSessionFee());
        auditDTO.setEndTime(sessionEntity.getEndTime());
        auditDTO.setTopic(sessionEntity.getTopic());
        return auditDTO;
    }
}