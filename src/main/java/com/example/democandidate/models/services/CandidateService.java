package com.example.democandidate.models.services;

import com.example.democandidate.models.dto.req.CandidateCreateDTO;
import com.example.democandidate.models.entities.Candidate;

public interface CandidateService {

    Candidate create(CandidateCreateDTO request);

}
