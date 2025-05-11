package com.skillmentor.root.service;

import com.skillmentor.root.dto.SessionDTO;

import java.util.List;

public interface SessionService {

    /**
     * Creates a new session.
     *
     * @param sessionDTO the session data transfer object containing session details
     * @return the created session data transfer object
     */
    public abstract SessionDTO createSession(SessionDTO sessionDTO);

    /**
     * Retrieves a session by its ID.
     * @param sessionId
     * @return
     */
    public abstract SessionDTO getSessionById(Integer sessionId);

    /**
     * Retrieves all sessions.
     *
     * @return a list of session data transfer objects
     */
    public abstract List<SessionDTO> getAllSessions();
}
