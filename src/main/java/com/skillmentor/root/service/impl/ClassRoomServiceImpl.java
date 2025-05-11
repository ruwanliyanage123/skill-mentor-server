package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.mapper.ClassRoomEntityDTOMapper;
import com.skillmentor.root.mapper.MentorEntityDTOMapper;
import com.skillmentor.root.repository.ClassRoomRepository;
import com.skillmentor.root.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoomDTO> getAllClassRooms() {
        List<ClassRoomEntity> classRoomEntities = classRoomRepository.findAll();
        return classRoomEntities.stream().map(
                entity->{
                    ClassRoomDTO classRoomDTO = ClassRoomEntityDTOMapper.map(entity);
                    List<MentorDTO> mentorDTOS = entity.getMentorEntities().stream()
                            .map(MentorEntityDTOMapper::map)
                            .collect(Collectors.toList());
                    classRoomDTO.setMentorDTOList(mentorDTOS);
                    return classRoomDTO;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public ClassRoomDTO findClassRoomById(Integer id) {
        Optional<ClassRoomEntity> classRoomEntity = classRoomRepository.findById(id);
        if (classRoomEntity.isEmpty()) {
            throw new RuntimeException("ClassRoom not found");
        }
        return ClassRoomEntityDTOMapper.map(classRoomEntity.get());
    }

    @Override
    public ClassRoomDTO deleteClassRoomById(Integer id) {
        Optional<ClassRoomEntity> classRoomEntity = classRoomRepository.findById(id);
        if (classRoomEntity.isEmpty()) {
            throw new RuntimeException("ClassRoom not found");
        }
        classRoomRepository.deleteById(id);
        return ClassRoomEntityDTOMapper.map(classRoomEntity.get());
    }

    @Override
    public ClassRoomDTO updateClassRoom(ClassRoomDTO classRoomDTO) {
        Optional<ClassRoomEntity> classRoomEntity = classRoomRepository.findById(classRoomDTO.getClassRoomId());
        if (classRoomEntity.isEmpty()) {
            throw new RuntimeException("ClassRoom not found");
        }
        ClassRoomEntity updatedEntity = classRoomEntity.get();
        updatedEntity.setTitle(classRoomDTO.getTitle());
        updatedEntity.setSessionFee(classRoomDTO.getSessionFee());
        updatedEntity.setEnrolledStudentCount(classRoomDTO.getEnrolledStudentCount());
        ClassRoomEntity savedEntity = classRoomRepository.save(updatedEntity);
        return ClassRoomEntityDTOMapper.map(savedEntity);
    }

    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        ClassRoomEntity classRoomEntity = ClassRoomEntityDTOMapper.map(classRoomDTO);
        if (classRoomDTO.getMentorDTOList().size()>0) {
            List<MentorEntity> mentorEntities = classRoomDTO.getMentorDTOList().stream()
                    .map(MentorEntityDTOMapper::map)
                    .collect(Collectors.toList());
            classRoomEntity.setMentorEntities(mentorEntities);
        }
        ClassRoomEntity savedEntity = classRoomRepository.save(classRoomEntity);
        ClassRoomDTO returnedClassRoomDTO = ClassRoomEntityDTOMapper.map(savedEntity);
        if (savedEntity.getMentorEntities().size()>0) {
            List<MentorDTO> mentorDTOS = savedEntity.getMentorEntities().stream()
                    .map(MentorEntityDTOMapper::map)
                    .collect(Collectors.toList());
            returnedClassRoomDTO.setMentorDTOList(mentorDTOS);
        }
        return ClassRoomEntityDTOMapper.map(savedEntity);
    }
}