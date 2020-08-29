package com.app.bahia.fibonacci.serie.backend.service;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FibonacciSerieService {

    public String getFibonacciSerie(final String limitOfSerie) {

        return Stream.iterate(new long[]{0, 1}, fn -> new long[]{fn[1], fn[0] + fn[1]})
                .limit(Integer.parseInt(limitOfSerie))
                .map(t -> t[0])
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
