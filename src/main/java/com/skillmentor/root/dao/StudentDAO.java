package com.skillmentor.root.dao;

import com.skillmentor.root.dto.StudentDTO;

import java.util.List;

public interface StudentDAO {

    /**
     * Creates a new student.
     *
     * @param studentDTO the data transfer object containing student details
     * @return the created StudentDTO object
     */
    StudentDTO createStudent(StudentDTO studentDTO);

    /**
     * Retrieves all students, optionally filtered by age.
     *
     * @param age the age to filter students by (optional)
     * @return a list of StudentDTO objects representing the students
     */
    List<StudentDTO> getAllStudents();

    /**
     * Retrieves a student by their ID.
     *
     * @param id the ID of the student to retrieve
     * @return a StudentDTO object representing the student
     */
    StudentDTO getStudentById(Integer id);

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
