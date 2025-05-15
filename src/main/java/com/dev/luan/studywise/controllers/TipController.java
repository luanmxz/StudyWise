package com.dev.luan.studywise.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.luan.studywise.dto.create_tip.request.CreateTipRequest;
import com.dev.luan.studywise.model.Tip;
import com.dev.luan.studywise.services.TipService;

@RestController
@RequestMapping("/api/tip")
public class TipController {

    private TipService tipService;

    public TipController(TipService tipService) {
        this.tipService = tipService;
    }

    @PostMapping("/create")
    public ResponseEntity<Tip> createTip(@RequestBody CreateTipRequest createTipRequest)
            throws URISyntaxException, IOException, InterruptedException {

        Tip tip = tipService.createTip(createTipRequest.tag(), createTipRequest.difficulty());

        return ResponseEntity.status(201).body(tip);
    }
}
