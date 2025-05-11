package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.mapper.ClassRoomEntityDTOMapper;
import com.skillmentor.root.mapper.MentorEntityDTOMapper;
import com.skillmentor.root.repository.ClassRoomRepository;
import com.skillmentor.root.repository.MentorRepository;
import com.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        MentorEntity mentorEntity = MentorEntityDTOMapper.map(mentorDTO);
        if (mentorDTO.getClassRoomId() != null) {
            Optional<ClassRoomEntity> optionalClassRoomEntity = classRoomRepository.findById(mentorDTO.getClassRoomId());
            if (optionalClassRoomEntity.isPresent()) {
                ClassRoomEntity classRoomEntity = optionalClassRoomEntity.get();
                mentorEntity.setClassRoomEntity(classRoomEntity);
                ClassRoomDTO classRoomDTO = ClassRoomEntityDTOMapper.map(classRoomEntity);
                classRoomDTO.getMentorDTOList().add(mentorDTO);
            }
        }
        MentorEntity savedEntity = mentorRepository.save(mentorEntity);
        MentorDTO savedMentorDTO = MentorEntityDTOMapper.map(savedEntity);
        savedMentorDTO.setClassRoomDTO(mentorDTO.getClassRoomDTO());
        savedMentorDTO.setClassRoomId(mentorDTO.getClassRoomId());
        return savedMentorDTO;
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
        Optional<MentorEntity> mentorEntityOptional = mentorRepository.findById(mentorDTO.getMentorId());
        if (mentorEntityOptional.isPresent()) {
            MentorEntity mentorEntity = mentorEntityOptional.get();
            mentorEntity.setFirstName(mentorDTO.getFirstName());
            mentorEntity.setLastName(mentorDTO.getLastName());
            mentorEntity.setEmail(mentorDTO.getEmail());
            mentorEntity.setProfession(mentorDTO.getProfession());
            mentorEntity.setAddress(mentorDTO.getAddress());
            mentorEntity.setTitle(mentorDTO.getTitle());
            mentorEntity.setSubject(mentorDTO.getSubject());
            mentorEntity.setQualification(mentorDTO.getQualification());

            ClassRoomEntity classRoomEntity = null;
            if (mentorDTO.getClassRoomId() != null) {
                Optional<ClassRoomEntity> optionalClassRoomEntity = classRoomRepository.findById(mentorDTO.getClassRoomId());
                if (optionalClassRoomEntity.isPresent()) {
                    classRoomEntity = optionalClassRoomEntity.get();
                }
            }
            mentorEntity.setClassRoomEntity(classRoomEntity);
            MentorEntity updatedMentor = mentorRepository.save(mentorEntity);
            return MentorEntityDTOMapper.map(updatedMentor);
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