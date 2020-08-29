package com.app.bahia.fibonacci.serie.backend.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FibonacciSerieService.class)
class FibonacciSerieServiceTest {

    private static final String VALUE_NUMBER_OF_SERIE = "10";

    @Autowired
    private FibonacciSerieService fibonacciSerieService;

    @Test
    void returnFibonacciResultForTheFirstTenNumbers() {

        final String result = this.fibonacciSerieService.getFibonacciSerie(VALUE_NUMBER_OF_SERIE);

        Assert.assertTrue(result.contains("21"));
    }

    @Test
    void returnFibonacciResultForTheFirstTenNumbersWithNonNumberParameter() {

        Exception exception = Assert.assertThrows(NumberFormatException.class, () -> {
            this.fibonacciSerieService.getFibonacciSerie("ZYX");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void returnFibonacciResultForTheFirstTenNumbersWithNegativeNumberParameter() {

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            this.fibonacciSerieService.getFibonacciSerie("-1");
        });

        String expectedMessage = "-1";
        String actualMessage = exception.getMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
