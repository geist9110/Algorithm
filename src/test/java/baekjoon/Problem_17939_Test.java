package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_17939_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_17939());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("4\n1 2 3 4", "6"),
                Arguments.of("6\n1 5 10 2 4 3", "16"),
                Arguments.of("5\n10 1 2 3 4", "6"),
                Arguments.of("5\n1 3 2 4 10", "30"));

    }

}
