package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.mapper.MentorEntityDTOMapper;
import com.skillmentor.root.repository.MentorRepository;
import com.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        MentorEntity mentorEntity = MentorEntityDTOMapper.map(mentorDTO);
        MentorEntity savedEntity = mentorRepository.save(mentorEntity);
        return MentorEntityDTOMapper.map(savedEntity);
    }

    @Override
    public List<MentorDTO> getAllMentors(List<String> firstNames, List<String> subjects) {
        List<MentorEntity> mentorEntities = mentorRepository.findAll();
        return mentorEntities.stream()
                .filter(mentor -> firstNames == null || firstNames.isEmpty() || firstNames.contains(mentor.getFirstName()))
                .filter(mentor -> subjects == null || subjects.isEmpty() || subjects.contains(mentor.getSubject()))
                .map(MentorEntityDTOMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public MentorDTO getMentorById(Integer id) {
        Optional<MentorEntity> mentorEntity = mentorRepository.findById(id);
        return mentorEntity.map(MentorEntityDTOMapper::map).orElse(null);
    }

    @Override
    public MentorDTO updateMentorById(MentorDTO mentorDTO) {
        MentorEntity mentorEntity = mentorRepository.findById(mentorDTO.getMentorId()).orElse(null);
        if (mentorEntity != null) {
            mentorEntity.setFirstName(mentorDTO.getFirstName());
            mentorEntity.setLastName(mentorDTO.getLastName());
            mentorEntity.setEmail(mentorDTO.getEmail());
            mentorEntity.setSubject(mentorDTO.getSubject());
            mentorEntity.setQualification(mentorDTO.getQualification());
            MentorEntity updatedEntity = mentorRepository.save(mentorEntity);
            return MentorEntityDTOMapper.map(updatedEntity);
        }
        return null;
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        MentorEntity mentorEntity = mentorRepository.findById(id).orElse(null);
        if (mentorEntity != null) {
            mentorRepository.deleteById(id);
        }
        return MentorEntityDTOMapper.map(mentorEntity);
    }
}