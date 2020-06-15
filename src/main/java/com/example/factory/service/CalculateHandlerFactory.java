package com.example.factory.service;

import com.example.factory.enums.CalculateType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculateHandlerFactory {

    private final SinusService sinusService;
    private final CosineService cosineService;

    public CalculateService getCalculateType(CalculateType calculateType) {
        return CalculateType.SIN.equals(calculateType) ? sinusService : cosineService;
    }
}
