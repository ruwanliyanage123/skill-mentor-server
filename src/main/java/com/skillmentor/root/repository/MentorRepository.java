package com.skillmentor.root.repository;

import com.skillmentor.root.dto.MentorDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class MentorRepository {
    private List<MentorDTO> mentors = new ArrayList<>();

    public MentorDTO createMentor(MentorDTO mentorDTO) {
        mentors.add(mentorDTO);
        return mentorDTO;
    }

    public List<MentorDTO> getAllMentors() {
        return new ArrayList<>(mentors);
    }

    public MentorDTO getMentorById(Integer id) {
        Optional<MentorDTO> mentorDTOOptional = mentors.stream()
                .filter(mentor -> Objects.equals(mentor.getMentorId(), id))
                .findFirst();
        return mentorDTOOptional.orElse(null);
    }

    public MentorDTO updateMentorById(MentorDTO mentorDTO) {
        Optional<MentorDTO> mentorDTOOptional = mentors.stream()
                .filter(mentor -> Objects.equals(mentor.getMentorId(), mentorDTO.getMentorId()))
                .findFirst();
        MentorDTO updatedMentor = mentorDTOOptional.orElse(null);
        if (updatedMentor != null) {
            updatedMentor.setFirstName(mentorDTO.getFirstName());
            updatedMentor.setLastName(mentorDTO.getLastName());
            updatedMentor.setEmail(mentorDTO.getEmail());
            updatedMentor.setProfession(mentorDTO.getProfession());
            updatedMentor.setSubject(mentorDTO.getSubject());
            updatedMentor.setQualification(mentorDTO.getQualification());
        }
        return updatedMentor;
    }

    public MentorDTO deleteMentorById(Integer id) {
        MentorDTO mentorDTO = getMentorById(id);
        if (mentorDTO != null) {
            mentors.remove(mentorDTO);
        }
        return mentorDTO;
    }
}