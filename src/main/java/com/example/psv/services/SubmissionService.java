package com.example.psv.services;

import com.example.psv.model.Submission;
import com.example.psv.model.User;
import com.example.psv.repositories.SubmissionRepository;
import com.example.psv.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {
  SubmissionRepository submissionsRepository;

    UserRepository userRepository;

    public SubmissionService(SubmissionRepository submissionsRepository, UserRepository userRepository){
        this.submissionsRepository = submissionsRepository;
        this.userRepository = userRepository;
    }



    public List<Submission> getAllSubmissions() {
        return (List<Submission>) submissionsRepository.findAll();
    }

    public List<Submission> getSubmissonByOwnerId(User owner){
        return submissionsRepository.findSubmissionsByOwner(owner);
    }


    public List<Submission> getSubmissionsByCompetitionName(String competitionName){
        return submissionsRepository.findByCompetitionName(competitionName);
    }

    public Submission createSubmissions(Submission submissions, Long userId){
        User user= userRepository.findById(userId).orElse(null);
        submissions.setOwner(user);
        return submissionsRepository.save(submissions);
    }



    public void deleteSubmissionsById( Long submissionId){
        submissionsRepository.deleteById(submissionId);
    }



}
