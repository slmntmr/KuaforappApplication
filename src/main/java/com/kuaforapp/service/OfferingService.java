package com.kuaforapp.service;

import com.kuaforapp.dto.Request.OfferingRequest;
import com.kuaforapp.dto.Response.OfferingResponse;
import com.kuaforapp.entity.Offering;
import com.kuaforapp.mapper.Mapper;
import com.kuaforapp.repository.OfferingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferingService {

    private final OfferingRepository offeringRepository;
    private final Mapper mapper;

    // Yeni offering oluşturma
    public OfferingResponse createOffering(OfferingRequest request) {
        Offering offering = mapper.requestToOffering(request); // Mapper ile dönüştürüyoruz
        offering = offeringRepository.save(offering);
        return mapper.offeringToResponse(offering); // Mapper ile dönüştürüyoruz
    }

    // Tüm offerings'leri getirme
    public List<OfferingResponse> getAllOfferings() {
        return offeringRepository.findAll().stream()
                .map(mapper::offeringToResponse) // Mapper ile dönüştürüyoruz
                .collect(Collectors.toList());
    }
}
