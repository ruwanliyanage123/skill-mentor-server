package com.skillmentor.root.service;

import com.skillmentor.root.dto.SessionDTO;
import com.skillmentor.root.dto.SessionLiteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SessionService {
    public abstract SessionDTO createSession(SessionLiteDTO sessionDTO);

    public abstract List<SessionDTO> getAllSessions();
}
