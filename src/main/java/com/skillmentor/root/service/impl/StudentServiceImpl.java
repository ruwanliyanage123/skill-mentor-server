package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.StudentEntity;
import com.skillmentor.root.mapper.StudentEntityDTOMapper;
import com.skillmentor.root.repository.StudentRepository;
import com.skillmentor.root.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        final StudentEntity studentEntity = StudentEntityDTOMapper.map(studentDTO);
        final StudentEntity savedEntity = studentRepository.save(studentEntity);
        return StudentEntityDTOMapper.map(savedEntity);
    }

    @Override
    public List<StudentDTO> getAllStudents(List<String> addresses, List<Integer> ages) {
        final List<StudentEntity> studentEntities = studentRepository.findAll();
        return studentEntities
                .stream()
                .filter(student-> addresses == null || addresses.contains(student.getAddress()))
                .filter(student-> ages == null || ages.contains(student.getAge()))
                .map(StudentEntityDTOMapper::map)
                .toList();
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if(studentEntity.isPresent()){
            return StudentEntityDTOMapper.map(studentEntity.get());
        }
        return null;
    }

 @Override
public StudentDTO updateStudentById(StudentDTO studentDTO) {
    StudentEntity studentEntity = studentRepository.findById(studentDTO.getStudentId()).orElse(null);
    if (studentEntity != null) {
        studentEntity.setFirstName(studentDTO.getFirstName());
        studentEntity.setLastName(studentDTO.getLastName());
        studentEntity.setEmail(studentDTO.getEmail());
        studentEntity.setPhoneNumber(studentDTO.getPhoneNumber());
        studentEntity.setAddress(studentDTO.getAddress());
        studentEntity.setAge(studentDTO.getAge());
        StudentEntity updatedEntity = studentRepository.save(studentEntity);
        return StudentEntityDTOMapper.map(updatedEntity);
    }
    return null;
}

    @Override
    public StudentDTO deleteStudentById(Integer id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        studentRepository.deleteById(id);
        return StudentEntityDTOMapper.map(studentEntity);
    }
}
