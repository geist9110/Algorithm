package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1345_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1345(), 10e-9);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("4 0\n6 13 20 27", "6.75"),
                Arguments.of("5 1\n2 3 4 5 6", "1.0"),
                Arguments.of("0 3", "0.0"),
                Arguments.of("5 3\n3 3 3 3 4", "0.2"),
                Arguments.of("1 1\n-3", "-1"),
                Arguments.of("2 0\n6 14", "-1"),
                Arguments.of("3 5\n4 3 2", "-1"));
    }

}
