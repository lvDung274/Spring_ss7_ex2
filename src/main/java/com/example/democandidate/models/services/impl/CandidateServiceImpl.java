package com.example.democandidate.models.services.impl;

import com.example.democandidate.models.dto.req.CandidateCreateDTO;
import com.example.democandidate.models.entities.Candidate;
import com.example.democandidate.models.repositories.CandidateRepository;
import com.example.democandidate.models.services.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;

    @Override
    public Candidate create(CandidateCreateDTO request){

        Candidate candidate =Candidate.builder()
                .fullName(request.fullName())
                .email(request.email())
                .age(request.age())
                .yearsOfExperience(request.yearsOfExperience())
                .build();
        return candidateRepository.save(candidate);
    }

}
