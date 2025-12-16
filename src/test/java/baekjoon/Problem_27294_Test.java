package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_27294_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27294());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("16 0", "320"),
                Arguments.of("14 1", "280"),
                Arguments.of("17 0", "280"),
                Arguments.of("10 1", "280"),
                Arguments.of("10 0", "280"));
    }

}
