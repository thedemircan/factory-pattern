package com.example.factory.controller;

import com.example.factory.enums.CalculateType;
import com.example.factory.service.CalculateHandlerFactory;
import com.example.factory.service.CalculateService;
import com.example.factory.service.SinusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CalculateController.class)
public class CalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculateHandlerFactory calculateHandlerFactory;

    @Test
    public void it_should_calculate() throws Exception {
        // Given
        CalculateService sinusService = mock(SinusService.class);

        when(calculateHandlerFactory.getCalculateType(CalculateType.SIN)).thenReturn(sinusService);

        // When
        ResultActions resultAction = mockMvc.perform(get("/")
                                                         .param("value", "90")
                                                         .param("calculateType", "SIN"));

        // Then
        resultAction.andExpect(status().isOk());
        verify(calculateHandlerFactory).getCalculateType(CalculateType.SIN);
        verify(sinusService).calculate(90D);
    }
}
