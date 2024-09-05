package com.kuaforapp.controller;

import com.kuaforapp.dto.Request.OfferingRequest;
import com.kuaforapp.dto.Response.OfferingResponse;

import com.kuaforapp.service.OfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offerings")
@RequiredArgsConstructor
public class OfferingController {

    private final OfferingService offeringService;

    @PostMapping
    public OfferingResponse createOffering(@RequestBody OfferingRequest request) {
        return offeringService.createOffering(request);
    }

    @GetMapping
    public List<OfferingResponse> getAllOfferings() {
        return offeringService.getAllOfferings();
    }
}
