package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_5623_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5623());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2\n0 2\n2 0", "1 1"),
                Arguments.of("4\n0 3 6 7\n3 0 5 6\n6 5 0 9\n7 6 9 0", "2 1 4 5"));
    }
}
