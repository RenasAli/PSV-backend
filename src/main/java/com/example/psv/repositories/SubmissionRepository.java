package com.example.psv.repositories;

import com.example.psv.model.Submission;
import com.example.psv.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {
   List<Submission> findSubmissionsByOwner(User owner);


   List<Submission> findByCompetitionName(String competitionName);
}
