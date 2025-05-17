package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.StudentEntity;
import com.skillmentor.root.exception.StudentException;
import com.skillmentor.root.mapper.StudentEntityDTOMapper;
import com.skillmentor.root.repository.StudentRepository;
import com.skillmentor.root.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    @CacheEvict(value = {"studentCache", "allStudentsCache"}, allEntries = true)
    public StudentDTO createStudent(final StudentDTO studentDTO) {
        if (studentDTO == null) {
            throw new IllegalArgumentException("Student data must not be null.");
        }
        final StudentEntity studentEntity = StudentEntityDTOMapper.map(studentDTO);
        final StudentEntity savedEntity = studentRepository.save(studentEntity);
        return StudentEntityDTOMapper.map(savedEntity);
    }

    @Override
    @Cacheable(value = "allStudentsCache", key = "'allStudents'")
    public List<StudentDTO> getAllStudents(final List<String> addresses, final List<Integer> ages, final List<String> firstNames) {
        final List<StudentEntity> studentEntities = studentRepository.findAll();
        return studentEntities
                .stream()
                .filter(student-> addresses == null || addresses.contains(student.getAddress()))
                .filter(student-> ages == null || ages.contains(student.getAge()))
                .filter(student -> firstNames == null || firstNames.contains(student.getFirstName()))
                .map(StudentEntityDTOMapper::map)
                .toList();
    }

    @Override
    @Cacheable(value = "studentCache", key = "#id")
    public StudentDTO findStudentById(final Integer id){
        return studentRepository.findById(id)
                .map(StudentEntityDTOMapper::map)
                .orElseThrow(() -> new StudentException("Student not found with ID: " + id));
    }

    @Override
    @CachePut(value = "studentCache", key = "#studentDTO.studentId")
    @CacheEvict(value = "allStudentsCache", allEntries = true)
    public StudentDTO updateStudentById(final StudentDTO studentDTO){
        if (studentDTO == null || studentDTO.getStudentId() == null) {
            throw new IllegalArgumentException("Student ID must not be null for update.");
        }
        final StudentEntity studentEntity = studentRepository.findById(studentDTO.getStudentId())
                .orElseThrow(() -> new StudentException("Cannot update. Student not found with ID: " + studentDTO.getStudentId()));
        studentEntity.setFirstName(studentDTO.getFirstName());
        studentEntity.setLastName(studentDTO.getLastName());
        studentEntity.setEmail(studentDTO.getEmail());
        studentEntity.setPhoneNumber(studentDTO.getPhoneNumber());
        studentEntity.setAddress(studentDTO.getAddress());
        studentEntity.setAge(studentDTO.getAge());
        return StudentEntityDTOMapper.map(studentRepository.save(studentEntity));
    }

    @Override
    @CacheEvict(value = {"studentCache", "allStudentsCache"}, key = "#id")
    public StudentDTO deleteStudentById(final Integer id){
        final StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new StudentException("Cannot delete. Student not found with ID: " + id));
        studentRepository.delete(studentEntity);
        return StudentEntityDTOMapper.map(studentEntity);
    }
}
