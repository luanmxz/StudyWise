package com.dev.luan.learn.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.luan.learn.dto.create_tip.request.CreateTipRequest;
import com.dev.luan.learn.dto.create_tip.response.CreateTipResponse;
import com.dev.luan.learn.services.TipService;

@RestController
@RequestMapping("/api/tip")
public class TipController {

    private TipService tipService;

    public TipController(TipService tipService) {
        this.tipService = tipService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTip(@RequestBody CreateTipRequest createTipRequest)
            throws URISyntaxException, IOException, InterruptedException {
        CreateTipResponse tip = tipService.createTip(createTipRequest.tag());

        return ResponseEntity.status(201).body(tip.choices().get(0).getMessage().getContent());
    }
}
