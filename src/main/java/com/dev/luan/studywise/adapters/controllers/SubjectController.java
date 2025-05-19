package com.dev.luan.studywise.adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.luan.studywise.adapters.dto.create_subject.CreateSubjectRequest;
import com.dev.luan.studywise.adapters.dto.create_subject.CreateSubjectResponse;
import com.dev.luan.studywise.application.services.SubjectService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('subjects:create') || hasRole('ADMIN')")
    public ResponseEntity<CreateSubjectResponse> create(@AuthenticationPrincipal Jwt jwt,
            @RequestBody @Valid CreateSubjectRequest createSubjectRequest) {

        CreateSubjectResponse createSubjectResponse = subjectService.createSubject(createSubjectRequest);

        return ResponseEntity.status(201).body(createSubjectResponse);
    }
}
