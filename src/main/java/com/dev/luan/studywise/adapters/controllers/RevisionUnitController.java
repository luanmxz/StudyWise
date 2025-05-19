package com.dev.luan.studywise.adapters.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.luan.studywise.adapters.dto.create_revision_unit.request.CreateRevisionUnitRequest;
import com.dev.luan.studywise.application.services.RevisionUnitService;
import com.dev.luan.studywise.application.services.SmsService;
import com.dev.luan.studywise.domain.model.RevisionUnit;

@RestController
@RequestMapping("/api/revisionUnit")
public class RevisionUnitController {

    private RevisionUnitService revisionUnitService;
    private SmsService smsService;

    public RevisionUnitController(RevisionUnitService revisionUnitService, SmsService smsService) {
        this.revisionUnitService = revisionUnitService;
        this.smsService = smsService;
    }

    @PostMapping("/create")
    public ResponseEntity<RevisionUnit> createRevisionUnit(
            @RequestBody CreateRevisionUnitRequest createRevisionUnitRequest)
            throws URISyntaxException, IOException, InterruptedException {

        RevisionUnit revisionUnit = revisionUnitService.createRevisionUnit(createRevisionUnitRequest);

        return ResponseEntity.status(201).body(revisionUnit);
    }

    @GetMapping("/sms")
    public ResponseEntity<String> getSms(@RequestParam String fromNumber) {

        String sms = smsService.getLastSms(fromNumber);

        return ResponseEntity.ok().body(sms);
    }
}
