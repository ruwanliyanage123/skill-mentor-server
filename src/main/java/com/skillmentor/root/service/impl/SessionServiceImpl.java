package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.AuditDTO;
import com.skillmentor.root.dto.PaymentDTO;
import com.skillmentor.root.dto.SessionDTO;
import com.skillmentor.root.dto.SessionLiteDTO;
import com.skillmentor.root.entity.LiteSessionEntity;
import com.skillmentor.root.entity.SessionEntity;
import com.skillmentor.root.mapper.AuditDTOEntityMapper;
import com.skillmentor.root.mapper.LiteSessionEntityDTOMapper;
import com.skillmentor.root.mapper.SessionDTOEntityMapper;
import com.skillmentor.root.repository.LiteSessionRepository;
import com.skillmentor.root.repository.SessionRepository;
import com.skillmentor.root.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private LiteSessionRepository liteSessionRepository;

    public SessionServiceImpl() {
    }

    @Override
    public SessionLiteDTO createSession(final SessionLiteDTO sessionDTO) {
        if (sessionDTO == null) {
            throw new IllegalArgumentException("Session data must not be null.");
        }
        LiteSessionEntity sessionEntity = LiteSessionEntityDTOMapper.map(sessionDTO);
        LiteSessionEntity savedEntity = liteSessionRepository.save(sessionEntity);
        return LiteSessionEntityDTOMapper.map(savedEntity);
    }

    @Override
    public List<SessionDTO> getAllSessions() {
        List<SessionEntity> sessions = sessionRepository.findAll();
        return sessions.stream().map(SessionDTOEntityMapper::map).toList();
    }

    @Override
    public List<AuditDTO> getAllAudits() {
        List<SessionEntity> sessions = sessionRepository.findAll();
        return sessions.stream().map(AuditDTOEntityMapper::map).toList();
    }

    @Override
    public List<PaymentDTO> findMentorPayments(String startDate, String endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date must not be null.");
        }
        List<Object> rawResults = sessionRepository.findMentorPayments(startDate, endDate);
        if (rawResults == null || rawResults.isEmpty()) {
            return Collections.emptyList();
        }
        return rawResults.stream().map(obj -> {
            Object[] row = (Object[]) obj;
            Integer mentorId = (Integer) row[0];
            String mentorName = (String) row[1];
            Double totalFee = (Double) row[2];
            return new PaymentDTO(mentorId, mentorName, totalFee);
        }).toList();
    }
}
