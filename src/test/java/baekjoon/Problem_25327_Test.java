package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_25327_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25327());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "5 4\nkor apple red\nkor pear blue\neng apple red\neng orange blue\nmath apple green\nkor apple red\nkor - blue\neng - -\n- - red",
                        "1\n1\n2\n2"),
                Arguments.of("3 4\nkor apple red\nkor apple red\nkor apple red\n- - -\nkor - -\neng - -\nmath - -",
                        "3\n3\n0\n0"));
    }

}
