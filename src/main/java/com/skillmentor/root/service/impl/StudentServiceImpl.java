package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.StudentEntity;
import com.skillmentor.root.exception.StudentException;
import com.skillmentor.root.mapper.StudentEntityDTOMapper;
import com.skillmentor.root.repository.StudentRepository;
import com.skillmentor.root.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Value("${spring.datasource.url}")
    private String datasource;

    @Autowired
    StudentRepository studentRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
//    @CacheEvict(value = {"studentCache", "allStudentsCache"}, allEntries = true)
    public StudentDTO createStudent(final StudentDTO studentDTO) {
        log.info("Creating new student...");
        if (studentDTO == null) {
            log.error("Failed to create student: input DTO is null.");
            throw new IllegalArgumentException("Student data must not be null.");
        }
        log.debug("StudentDTO received: {}", studentDTO);
        final StudentEntity studentEntity = StudentEntityDTOMapper.map(studentDTO);
        final StudentEntity savedEntity = studentRepository.save(studentEntity);
        log.info("Student created with ID: {} at data-source: {}", savedEntity.getStudentId(), this.datasource);
        return StudentEntityDTOMapper.map(savedEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
//    @Cacheable(value = "allStudentsCache", key = "'allStudents'")
    public List<StudentDTO> getAllStudents(final List<String> addresses, final List<Integer> ages, final List<String> firstNames) {
        log.info("Fetching all students with filters: addresses={}, ages={}, firstNames={}", addresses, ages, firstNames);
        final List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDTO> result = studentEntities
                .stream()
                .filter(student -> addresses == null || addresses.contains(student.getAddress()))
                .filter(student -> ages == null || ages.contains(student.getAge()))
                .filter(student -> firstNames == null || firstNames.contains(student.getFirstName()))
                .map(StudentEntityDTOMapper::map)
                .toList();
        log.info("Found {} students after filtering from data-source: {}", result.size(), this.datasource);
        return result;
    }

    @Override
//    @Cacheable(value = "studentCache", key = "#id")
    @Transactional(rollbackFor = Exception.class)
    public StudentDTO findStudentById(final Integer id) {
        log.info("Fetching student by ID: {}", id);
        return studentRepository.findById(id)
                .map(student -> {
                    log.debug("Student found: {}", student);
                    return StudentEntityDTOMapper.map(student);
                })
                .orElseThrow(() -> {
                    log.error("Student not found with ID: {} from data-source:{}", id, this.datasource);
                    return new StudentException("Student not found with ID: " + id);
                });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
//    @CacheEvict(value = "allStudentsCache", allEntries = true)
//    @CachePut(value = "studentCache", key = "#studentDTO.studentId")
    public StudentDTO updateStudentById(final StudentDTO studentDTO) {
        log.info("Updating student...");
        if (studentDTO == null || studentDTO.getStudentId() == null) {
            log.error("Failed to update student: DTO or studentId is null.");
            throw new IllegalArgumentException("Student ID must not be null for update.");
        }
        log.debug("Updating student with ID: {}", studentDTO.getStudentId());
        final StudentEntity studentEntity = studentRepository.findById(studentDTO.getStudentId())
                .orElseThrow(() -> {
                    log.error("Cannot update. Student not found with ID: {}", studentDTO.getStudentId());
                    return new StudentException("Cannot update. Student not found with ID: " + studentDTO.getStudentId());
                });
        studentEntity.setFirstName(studentDTO.getFirstName());
        studentEntity.setLastName(studentDTO.getLastName());
        studentEntity.setEmail(studentDTO.getEmail());
        studentEntity.setPhoneNumber(studentDTO.getPhoneNumber());
        studentEntity.setAddress(studentDTO.getAddress());
        studentEntity.setAge(studentDTO.getAge());
        StudentEntity updated = studentRepository.save(studentEntity);
        log.info("Student updated with ID: {}", updated.getStudentId());
        return StudentEntityDTOMapper.map(updated);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
//    @CacheEvict(value = {"studentCache", "allStudentsCache"}, key = "#id")
    public StudentDTO deleteStudentById(final Integer id) {
        log.info("Deleting student with ID: {}", id);
        final StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Cannot delete. Student not found with ID: {}", id);
                    return new StudentException("Cannot delete. Student not found with ID: " + id);
                });
        studentRepository.delete(studentEntity);
        log.info("Student with ID {} deleted successfully", id);
        return StudentEntityDTOMapper.map(studentEntity);
    }
}
