package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1041_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1041());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2\n1 2 3 4 5 6", "36"),
                Arguments.of("3\n1 2 3 4 5 6", "69"),
                Arguments.of("1000000\n50 50 50 50 50 50", "250000000000000"),
                Arguments.of("10\n1 1 1 1 50 1", "500"),
                Arguments.of("3\n1 2 2 2 2 1", "65"),
                Arguments.of("2\n2 3 1 1 4 5", "36"));
    }
}
