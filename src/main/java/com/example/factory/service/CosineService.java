package com.example.factory.service;

import org.springframework.stereotype.Service;

@Service
public class CosineService implements CalculateService {

    @Override
    public double calculate(double value) {
        return Math.cos(value);
    }
}
