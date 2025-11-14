package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1063_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1063());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("A1 A2 5\nB\nL\nLB\nRB\nLT", "A1\nA2"),
                Arguments.of("A1 H8 1\nT", "A2\nH8"),
                Arguments.of("A1 A2 1\nT", "A2\nA3"),
                Arguments.of("A1 A2 2\nT\nR", "B2\nA3"),
                Arguments.of(
                        "A8 B7 18\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB\n" +
                                "RB",
                        "G2\nH1"),
                Arguments.of("C1 B1 3\nL\nT\nLB", "B2\nA1"),
                Arguments.of("B2 A1 1\nL", "A2\nA1"),
                Arguments.of("B2 A1 1\nLB", "B2\nA1"));
    }

}
