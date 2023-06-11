package com.example.psv.controller;

import com.example.psv.model.Submission;
import com.example.psv.model.User;
import com.example.psv.services.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/submission")
public class SubmissionController {
    SubmissionService submissionService;
    public SubmissionController(SubmissionService submissionService){
        this.submissionService = submissionService;
    }

    @GetMapping
    public ResponseEntity<List<Submission>> getAllSubmissions() {
        return  ResponseEntity.ok().body(submissionService.getAllSubmissions());
    }
    @GetMapping("/owner/{owner}")
    public ResponseEntity<List<Submission>> getSubmissionsByOwnerId(@PathVariable("owner") User owner){
        return ResponseEntity.ok().body(submissionService.getSubmissonByOwnerId(owner));
    }

    @GetMapping("/competition/{competitionName}")
    public ResponseEntity<List<Submission>> getSubmissionsByCompetitionName(
            @PathVariable("competitionName") String competitionName){
        return ResponseEntity.ok().body(submissionService.getSubmissionsByCompetitionName(competitionName));

    }

    @PostMapping("/{userId}/submission")
    public ResponseEntity<Submission>
    createSubmissions(@PathVariable Long userId,
                      @RequestBody Submission submissions) {
        return ResponseEntity.ok().body(submissionService.createSubmissions(submissions,
                userId));
    }

    @DeleteMapping("/{submissionId}")
    public void deleteSubmission(@PathVariable Long submissionId) {
        submissionService.deleteSubmissionsById(submissionId);
    }


}
