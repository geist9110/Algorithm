package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_29718_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_29718());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 4\n1 5 2 6\n2 3 1 5\n1 2 1 1\n2", "16"),
                Arguments.of("1 5\n1 3 2 5 4\n3", "11"),
                Arguments.of("5 1\n2\n3\n4\n5\n6\n1", "20"),
                Arguments.of("1 5\n1 6 6 6 1\n3", "18"),
                Arguments.of("1 5\n6 6 6 1 1\n3", "18"),
                Arguments.of("1 5\n1 2 3 4 5\n5", "15"),
                Arguments.of("1 1\n1\n1", "1"));
    }

}
