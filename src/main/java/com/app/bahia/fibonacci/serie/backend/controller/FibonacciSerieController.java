package com.app.bahia.fibonacci.serie.backend.controller;

import com.app.bahia.fibonacci.serie.backend.service.FibonacciSerieService;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class FibonacciSerieController {

    private final FibonacciSerieService fibonacciSerieService;

    public FibonacciSerieController(final FibonacciSerieService fibonacciSerieService) {
        this.fibonacciSerieService = fibonacciSerieService;
    }

    @GetMapping(path = "/getFibonacciSerie/{limitOfSerie}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFibonacciSerie(@PathVariable final String limitOfSerie) {
        return JSONObject.quote(this.fibonacciSerieService.getFibonacciSerie(limitOfSerie));
    }
}
