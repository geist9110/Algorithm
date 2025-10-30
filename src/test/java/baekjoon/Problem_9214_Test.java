package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_9214_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_9214());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2221\n312211\n22\n0", "Test 1: 221\nTest 2: 1\nTest 3: 22"),
                Arguments.of("2212\n0", "Test 1: 2212"));
    }
}
