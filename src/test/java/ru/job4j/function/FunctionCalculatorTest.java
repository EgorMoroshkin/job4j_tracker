package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 3 * x + 1);
        List<Double> expected = Arrays.asList(16D, 19D, 22D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 3, x -> x * x + 1);
        List<Double> expected = Arrays.asList(2D, 5D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenIndicatorFunctionThenIndicatorrResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(4, 7, x -> Math.pow(3,x) + 1);
        List<Double> expected = Arrays.asList(82D, 244D, 730D);
        assertThat(result).containsAll(expected);
    }
}