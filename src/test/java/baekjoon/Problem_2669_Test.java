package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_2669_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2669());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
"""
1 2 4 4
2 3 5 7
3 1 6 5
7 3 8 6
""",
                        "26"));
    }
}
