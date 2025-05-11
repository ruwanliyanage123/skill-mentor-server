package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.SessionDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.entity.SessionEntity;
import com.skillmentor.root.entity.StudentEntity;
import com.skillmentor.root.mapper.SessionEntityDTOMapper;
import com.skillmentor.root.repository.ClassRoomRepository;
import com.skillmentor.root.repository.MentorRepository;
import com.skillmentor.root.repository.SessionRepository;
import com.skillmentor.root.repository.StudentRepository;
import com.skillmentor.root.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Create a new session
    public SessionDTO createSession(SessionDTO sessionDTO) {
        // Find related entities
        Optional<ClassRoomEntity> classRoomEntityOpt = classRoomRepository.findById(sessionDTO.getClassRoom().getClassRoomId());
        Optional<MentorEntity> mentorEntityOpt = mentorRepository.findById(sessionDTO.getMentor().getMentorId());
        Optional<StudentEntity> studentEntityOpt = studentRepository.findById(sessionDTO.getStudent().getStudentId());

        if (classRoomEntityOpt.isPresent() && mentorEntityOpt.isPresent() && studentEntityOpt.isPresent()) {
            SessionEntity sessionEntity = SessionEntityDTOMapper.map(
                    sessionDTO,
                    classRoomEntityOpt.get(),
                    mentorEntityOpt.get(),
                    studentEntityOpt.get()
            );
            sessionEntity = sessionRepository.save(sessionEntity);
            return SessionEntityDTOMapper.map(sessionEntity);
        }
        return null;
    }

    public SessionDTO getSessionById(Integer sessionId) {
        Optional<SessionEntity> sessionEntityOpt = sessionRepository.findById(sessionId);
        return sessionEntityOpt.map(SessionEntityDTOMapper::map).orElse(null);
    }

    public List<SessionDTO> getAllSessions() {
        List<SessionEntity> sessionEntities = sessionRepository.findAll();
        return sessionEntities.stream()
                .map(SessionEntityDTOMapper::map)
                .collect(Collectors.toList());
    }
}
