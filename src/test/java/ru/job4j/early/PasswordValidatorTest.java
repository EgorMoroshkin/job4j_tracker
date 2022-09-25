package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordValidatorTest  {

    @Test
    public void whenPasswordValid() {
        String input = "Success";
        String output = PasswordValidator.validate("Zimbabve39!");
        assertThat(output).isEqualTo(input);
    }
}