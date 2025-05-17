package com.skillmentor.root.service;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.exception.StudentException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for managing students.
 */
@Service
public interface StudentService {

    /**
     * Creates a new student.
     *
     * @param studentDTO the data transfer object containing student details
     * @return the created StudentDTO object
     */
    StudentDTO createStudent(StudentDTO studentDTO);

    /**
     * Retrieves all students, optionally filtered by age, firstName, address
     *
     * @param ages the age to filter students by (optional)
     * @return a list of StudentDTO objects representing the students
     */
    List<StudentDTO> getAllStudents(List<String> addresses, List<Integer> ages, List<String> firstNames);

    /**
     * Retrieves a student by their ID.
     *
     * @param id the ID of the student to retrieve
     * @return a StudentDTO object representing the student
     */
    StudentDTO findStudentById(Integer id);

    /**
     * Updates an existing student's details.
     *
     * @param studentDTO the data transfer object containing updated student details
     * @return a StudentDTO object representing the updated student
     */
    StudentDTO updateStudentById(StudentDTO studentDTO);

    /**
     * Deletes a student by their ID.
     *
     * @param id the ID of the student to delete
     * @return a StudentDTO object representing the deleted student
     */
    StudentDTO deleteStudentById(Integer id);
}