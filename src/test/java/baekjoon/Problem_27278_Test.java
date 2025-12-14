package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_27278_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27278());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5 1\n1 1 1 1 1\n1 5 0", "4"),
                Arguments.of("5 1\n1 1 1 1 1\n5 1 0", "5"),
                Arguments.of("5 1\n1 1 1 1 1\n5 1 4", "5"),
                Arguments.of("5 1\n1 1 1 1 1\n5 1 5", "10"),
                Arguments.of("5 1\n1 1 1 1 1\n5 4 5", "13"),
                Arguments.of("5 1\n1 1 1 1 1\n5 4 9", "13"),
                Arguments.of("5 7\n1 3 2 4 3\n1 2 0\n2 5 1\n3 4 2\n3 1 7\n5 4 10\n1 4 12\n4 3 4", "26"));
    }

}
