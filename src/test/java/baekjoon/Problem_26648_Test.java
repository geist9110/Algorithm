package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_26648_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_26648());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3\n1 2 3\n0 4 3\n5 3 3", "YES"),
                Arguments.of("4\n1 2 3 2\n0 3 3 2\n4 3 5 3", "NO"),
                Arguments.of("3\n2 1 2\n2 2 3\n2 3 3", "NO"),
                Arguments.of("3\n3 0 5\n3 0 5\n3 5 5", "YES"));
    }

}
