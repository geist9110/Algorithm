package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_17615_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_17615());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("9\nRBBBRBRRR", "2"),
                Arguments.of("8\nBBRBBBBR", "1"),
                Arguments.of("5\nRRRRR", "0"),
                Arguments.of("6\nRBRRBR", "2"),
                Arguments.of("6\nRRRBRR", "1"),
                Arguments.of("12\nRRBBRBBBRRRR", "3"),
                Arguments.of("5\nRBRBR", "2"),
                Arguments.of("10\nRRBBBRRRBB", "3"),
                Arguments.of("10\nBBBBBBBBBB", "0"),
                Arguments.of("10\nBRRRRRBBRR", "2"),
                Arguments.of("5\nRRBRR", "1"));
    }

}
