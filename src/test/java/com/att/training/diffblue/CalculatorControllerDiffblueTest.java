package com.att.training.diffblue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * This test was generated by the Diffblue intellij plugin (v2021.07.02-teams.2021.1)
 * This fixes the previous bug by adding a {@code @MockBean Calculator}
 */
@ContextConfiguration(classes = {CalculatorController.class})
@ExtendWith(SpringExtension.class)
public class CalculatorControllerDiffblueTest {
    @MockBean
    private Calculator calculator;

    @Autowired
    private CalculatorController calculatorController;

    @Test
    public void testAdd() throws Exception {
        when(this.calculator.add(anyInt(), anyInt())).thenReturn(2);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/calc/add");
        MockHttpServletRequestBuilder paramResult = getResult.param("x", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("y", String.valueOf(1));
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(this.calculatorController).build();
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("2"));
    }

    @Test
    public void testAbs() {
        CalculatorController calculatorController = new CalculatorController(new Calculator());
        int value = 42;
        int actualAbsResult = calculatorController.abs(value);
        assertEquals(42, actualAbsResult);
    }

    @Test
    public void testAbs2() {
        Calculator calculator = mock(Calculator.class);
        when(calculator.abs(anyInt())).thenReturn(1);
        CalculatorController calculatorController = new CalculatorController(calculator);
        int value = 42;
        int actualAbsResult = calculatorController.abs(value);
        assertEquals(1, actualAbsResult);
        verify(calculator).abs(anyInt());
    }

    @Test
    public void testAbs3() {
        CalculatorController calculatorController = new CalculatorController(new Calculator());
        int value = -1;
        int actualAbsResult = calculatorController.abs(value);
        assertEquals(1, actualAbsResult);
    }
}

