package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.exception.MentorException;
import com.skillmentor.root.mapper.MentorEntityDTOMapper;
import com.skillmentor.root.repository.ClassRoomRepository;
import com.skillmentor.root.repository.MentorRepository;
import com.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private ClassRoomRepository classRoomRepository;

    public MentorServiceImpl() {
    }

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) throws MentorException {
        final MentorEntity mentorEntity = MentorEntityDTOMapper.map(mentorDTO);
        if (mentorDTO.getClassRoomId() != null) {
            final ClassRoomEntity classRoomEntity = classRoomRepository.findById(mentorDTO.getClassRoomId())
                    .orElseThrow(() -> new MentorException("Classroom not found with ID: " + mentorDTO.getClassRoomId()));
            classRoomEntity.setMentor(mentorEntity);
            final MentorEntity savedMentor = mentorRepository.save(mentorEntity);
            classRoomRepository.save(classRoomEntity);
            return MentorEntityDTOMapper.map(savedMentor);
        }
        final MentorEntity savedEntity = mentorRepository.save(mentorEntity);
        return MentorEntityDTOMapper.map(savedEntity);
    }

    @Override
    public List<MentorDTO> getAllMentors(List<String> firstNames, List<String> subjects) {
        return mentorRepository.findAll().stream()
                .filter(mentor -> firstNames == null || firstNames.isEmpty() || firstNames.contains(mentor.getFirstName()))
                .filter(mentor -> subjects == null || subjects.isEmpty() || subjects.contains(mentor.getSubject()))
                .map(MentorEntityDTOMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public MentorDTO findMentorById(Integer id) throws MentorException {
        return mentorRepository.findById(id)
                .map(MentorEntityDTOMapper::map)
                .orElseThrow(() -> new MentorException("Mentor not found with ID: " + id));
    }

    @Override
    public MentorDTO updateMentorById(MentorDTO mentorDTO) throws MentorException {
       final MentorEntity mentorEntity = mentorRepository.findById(mentorDTO.getMentorId())
                .orElseThrow(() -> new MentorException("Cannot update. Mentor not found with ID: " + mentorDTO.getMentorId()));
        mentorEntity.setFirstName(mentorDTO.getFirstName());
        mentorEntity.setLastName(mentorDTO.getLastName());
        mentorEntity.setEmail(mentorDTO.getEmail());
        mentorEntity.setPhoneNumber(mentorDTO.getPhoneNumber());
        mentorEntity.setTitle(mentorDTO.getTitle());
        mentorEntity.setProfession(mentorDTO.getProfession());
        mentorEntity.setSubject(mentorDTO.getSubject());
        mentorEntity.setAddress(mentorDTO.getAddress());
        mentorEntity.setSessionFee(mentorDTO.getSessionFee());
        mentorEntity.setQualification(mentorDTO.getQualification());
        final MentorEntity updatedEntity = mentorRepository.save(mentorEntity);
        return MentorEntityDTOMapper.map(updatedEntity);
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) throws MentorException {
        final MentorEntity mentorEntity = mentorRepository.findById(id)
                .orElseThrow(() -> new MentorException("Cannot delete. Mentor not found with ID: " + id));
        mentorRepository.deleteById(id);
        return MentorEntityDTOMapper.map(mentorEntity);
    }
}
