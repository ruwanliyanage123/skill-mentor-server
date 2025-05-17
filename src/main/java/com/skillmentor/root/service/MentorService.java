package com.skillmentor.root.service;

import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.exception.MentorException;

import java.util.List;

/**
 * Service interface for managing mentors.
 */
public interface MentorService {

    /**
     * Creates a new mentor.
     *
     * @param mentorDTO the data transfer object containing mentor details
     * @return the created MentorDTO object
     */
    MentorDTO createMentor(MentorDTO mentorDTO) throws MentorException;

    /**
     * Retrieves all mentors.
     *
     * @return a list of MentorDTO objects representing all mentors
     */
    List<MentorDTO> getAllMentors(List<String> firstNames, List<String> subjects);

    /**
     * Retrieves a mentor by their ID.
     *
     * @param id the ID of the mentor to retrieve
     * @return a MentorDTO object representing the mentor
     */
    MentorDTO findMentorById(Integer id) throws MentorException;

    /**
     * Updates an existing mentor's details.
     *
     * @param mentorDTO the data transfer object containing updated mentor details
     * @return a MentorDTO object representing the updated mentor
     */
    MentorDTO updateMentorById(MentorDTO mentorDTO) throws MentorException;

    /**
     * Deletes a mentor by their ID.
     *
     * @param id the ID of the mentor to delete
     * @return a MentorDTO object representing the deleted mentor
     */
    MentorDTO deleteMentorById(Integer id) throws MentorException;
}