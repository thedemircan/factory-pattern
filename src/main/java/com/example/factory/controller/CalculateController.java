package com.example.factory.controller;

import com.example.factory.enums.CalculateType;
import com.example.factory.service.CalculateHandlerFactory;
import com.example.factory.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class CalculateController {

    private final CalculateHandlerFactory calculateHandlerFactory;

    @GetMapping
    public double calculate(@RequestParam Double value, @RequestParam CalculateType calculateType) {
        CalculateService calculateService = calculateHandlerFactory.getCalculateType(calculateType);
        return calculateService.calculate(value);
    }
}
