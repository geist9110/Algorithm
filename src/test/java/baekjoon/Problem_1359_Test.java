package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1359_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1359(), 10e-9);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 1 1", "0.3333333333333333"),
                Arguments.of("3 2 1", "1.0"),
                Arguments.of("8 2 1", "0.4642857142857143"),
                Arguments.of("8 4 2", "0.7571428571428571"));
    }

}
