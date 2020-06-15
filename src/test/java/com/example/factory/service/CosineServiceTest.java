package com.example.factory.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CosineServiceTest {

    @InjectMocks
    private CosineService cosineService;

    @Test
    public void it_should_calculate() {
        // When
        double result = cosineService.calculate(90D);

        // Then
        assertThat(result).isEqualTo(Math.cos(90D));
    }
}
