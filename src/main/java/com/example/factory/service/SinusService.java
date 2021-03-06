package com.example.factory.service;

import org.springframework.stereotype.Service;

@Service
public class SinusService implements CalculateService {

    @Override
    public double calculate(double value) {
        return Math.sin(value);
    }
}
