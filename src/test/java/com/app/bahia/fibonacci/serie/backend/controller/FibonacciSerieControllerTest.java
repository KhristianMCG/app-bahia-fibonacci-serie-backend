package com.app.bahia.fibonacci.serie.backend.controller;

import com.app.bahia.fibonacci.serie.backend.service.FibonacciSerieService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(classes = FibonacciSerieController.class)
@AutoConfigureMockMvc
class FibonacciSerieControllerTest {

    private static final String PARAM_NAME_NUMBER_OF_SERIE = "limitOfSerie";
    private static final String VALUE_NUMBER_OF_SERIE = "10";
    private static final String RESULT = "{0, 1, 2, 3, 5, 8, 13, 21, 34, 55}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FibonacciSerieService fibonacciSerieService;

    @Test
    void returnFibonacciResultForTheFirstTenNumbers() throws Exception {
        Mockito.when(this.fibonacciSerieService.getFibonacciSerie(VALUE_NUMBER_OF_SERIE)).thenReturn(RESULT);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/getFibonacciSerie/{" + PARAM_NAME_NUMBER_OF_SERIE + "}", VALUE_NUMBER_OF_SERIE))
                .andDo(MockMvcResultHandlers
                        .print())
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string(Matchers.containsString("21")))
                .andReturn();

        Mockito.verify(this.fibonacciSerieService, Mockito.times(1)).getFibonacciSerie(VALUE_NUMBER_OF_SERIE);
    }
}
