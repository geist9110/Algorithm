package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_27165_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27165());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("6\n4 0 1 0 0 2 1\n4", "YES\n2 6"),
                Arguments.of("6\n4 0 1 0 0 2 1\n5", "NO"),
                Arguments.of("3\n2 0 0 2\n3", "NO"),
                Arguments.of("10\n4 2 3 0 2 0 2 0 3 2 3\n3", "NO"),
                Arguments.of("4\n3 0 0 0 2\n1", "NO"),
                Arguments.of("6\n4 0 2 0 0 2 1\n6", "YES\n0 6"),
                Arguments.of("4\n3 0 0 0 1\n4", "YES\n0 4"),
                Arguments.of("4\n3 0 0 0 0\n4", "NO"),
                Arguments.of("1\n1 1\n1", "YES\n0 1"),
                Arguments.of("1\n1 0\n1", "NO"),
                Arguments.of("3\n1 0 1 2\n1", "NO"),
                Arguments.of("3\n1 0 1 2\n2", "YES\n0 2"),
                Arguments.of("3\n1 0 1 2\n3", "NO"),
                Arguments.of("5\n2 2 2 2 2 2\n1", "NO"),
                Arguments.of("5\n1 0 0 0 0 2\n1", "NO"));
    }
}
