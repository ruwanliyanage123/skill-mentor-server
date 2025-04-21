package com.skillmentor.root.service;

import com.skillmentor.root.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    /**
     * To create student
     *
     * @param studentDTO student dto
     * @return created student
     */
    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents(Integer age);

    StudentDTO getStudentById(Integer id);

    StudentDTO updateStudentById(StudentDTO studentDTO);

    StudentDTO deleteStudentById(Integer id);
}
