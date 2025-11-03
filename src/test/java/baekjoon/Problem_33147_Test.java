package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_33147_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_33147());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("6 2\n2 3 4 1 0 5", "YES"),
                Arguments.of("4 2\n0 1 3 2", "NO"),
                Arguments.of("7 1\n6 0 1 2 3 4 5", "YES"),
                Arguments.of("7 2\n6 0 1 2 3 4 5", "YES"));
    }
}
