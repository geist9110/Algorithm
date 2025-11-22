package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1500_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1500());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("10 3", "36"),
                Arguments.of("10 1", "10"),
                Arguments.of("10 10", "1"),
                Arguments.of("13 8", "32"),
                Arguments.of("7 2", "12"),
                Arguments.of("31 9", "62208"));
    }

}
