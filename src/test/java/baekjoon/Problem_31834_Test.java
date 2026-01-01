package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_31834_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_31834());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3\n5 5 1\n3 1 2\n7 3 5", "0\n1\n2"),
                Arguments.of("1\n5 3 1", "2"),
                Arguments.of("2\n2 1 2\n2 2 1", "0\n0"),
                Arguments.of("3\n5 1 3\n5 1 2\n5 1 5", "1\n1\n0"),
                Arguments.of("6\n5 3 1\n5 3 2\n5 3 4\n5 3 5\n5 2 4\n5 4 2", "2\n1\n1\n2\n2\n2"),
                Arguments.of("3\n5 5 1\n5 5 4\n5 5 3", "0\n1\n1"));
    }

}
