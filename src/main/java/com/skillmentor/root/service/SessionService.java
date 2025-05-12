package com.skillmentor.root.service;

import com.skillmentor.root.dto.AuditDTO;
import com.skillmentor.root.dto.PaymentDTO;
import com.skillmentor.root.dto.SessionDTO;
import com.skillmentor.root.dto.SessionLiteDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface SessionService {
    public abstract SessionLiteDTO createSession(SessionLiteDTO sessionDTO);

    public abstract List<SessionDTO> getAllSessions();

    public abstract List<AuditDTO> getAllAudits();

    public abstract List<PaymentDTO> findMentorPayments(String startDate, String endDate);
}
