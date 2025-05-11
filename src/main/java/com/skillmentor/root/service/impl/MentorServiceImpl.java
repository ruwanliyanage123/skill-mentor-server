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
import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        MentorEntity mentorEntity = MentorEntityDTOMapper.map(mentorDTO);
        if (mentorDTO.getClassRoomIds().size()>0) {
            List<ClassRoomEntity> classRoomEntities = classRoomRepository.findAllById(mentorDTO.getClassRoomIds());
            if (classRoomEntities.size()>0) {
                mentorEntity.setClassRoomEntities(classRoomEntities);
            }
        }
        MentorEntity savedEntity = mentorRepository.save(mentorEntity);
        MentorDTO savedMentorDTO = MentorEntityDTOMapper.map(savedEntity);
        if(savedEntity.getClassRoomEntities().size()>0) {
            List<ClassRoomDTO> savedDTOs = savedEntity.getClassRoomEntities().stream().map(ClassRoomEntityDTOMapper::map).toList();
            savedMentorDTO.setClassRoomDTOList(savedDTOs);
            for(ClassRoomDTO classRoomDTO : savedMentorDTO.getClassRoomDTOList()) {
                ClassRoomEntity classRoomEntity = classRoomRepository.findById(classRoomDTO.getClassRoomId()).orElse(null);
                if (classRoomEntity != null) {
                    classRoomEntity.getMentorEntities().add(savedEntity);
                    classRoomRepository.save(classRoomEntity);
                }
            }
        }
        return savedMentorDTO;
    }

    @Override
    public List<MentorDTO> getAllMentors(List<String> firstNames, List<String> subjects) {
        List<MentorEntity> mentorEntities = mentorRepository.findAll();
        return mentorEntities.stream().map(entity->{
            List<ClassRoomDTO> classRoomDTOS = entity.getClassRoomEntities().stream().map(ClassRoomEntityDTOMapper::map).toList();
            MentorDTO mentorDTO = MentorEntityDTOMapper.map(entity);
            mentorDTO.setClassRoomDTOList(classRoomDTOS);
            return mentorDTO;
        }).toList();
    }

    @Override
    public MentorDTO getMentorById(Integer id) {
        Optional<MentorEntity> mentorEntity = mentorRepository.findById(id);
        return mentorEntity.map(MentorEntityDTOMapper::map).orElse(null);
    }

    @Override
    public MentorDTO updateMentorById(MentorDTO mentorDTO) {
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