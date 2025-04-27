package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.repository.MentorRepository;
import com.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        MentorDTO mentor = mentorRepository.createMentor(mentorDTO);
        return mentor;
    }

    @Override
    public List<MentorDTO> getAllMentors() {
        return new ArrayList<>(mentorRepository.getAllMentors());
    }

    @Override
    public MentorDTO getMentorById(Integer id) {
        MentorDTO mentor = mentorRepository.getMentorById(id);
        if (mentor == null) {
            throw new RuntimeException("Mentor not found");
        }
        return mentor;
    }

    @Override
    public MentorDTO updateMentorById(MentorDTO mentorDTO) {
        MentorDTO mentor = mentorRepository.updateMentorById(mentorDTO);
        if (mentor == null) {
            throw new RuntimeException("Mentor not found");
        }
        return mentor;
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        MentorDTO mentor = mentorRepository.getMentorById(id);
        if (mentor != null) {
            mentorRepository.deleteMentorById(id);
        }
        return mentor;
    }

}

