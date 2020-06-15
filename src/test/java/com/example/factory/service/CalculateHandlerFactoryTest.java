package com.example.factory.service;

import com.example.factory.enums.CalculateType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CalculateHandlerFactoryTest {

    @InjectMocks
    private CalculateHandlerFactory calculateHandlerFactory;

    @Test
    public void it_should_get_calculate_type_when_type_is_sin() {
        // When
        CalculateService calculateService = calculateHandlerFactory.getCalculateType(CalculateType.SIN);

        // Then
        assertThat(calculateService instanceof SinusService);
    }

    @Test
    public void it_should_get_calculate_type_when_type_is_cos() {
        // When
        CalculateService calculateService = calculateHandlerFactory.getCalculateType(CalculateType.COS);

        // Then
        assertThat(calculateService instanceof CosineService);
    }
}
