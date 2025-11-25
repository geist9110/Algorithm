package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_5612_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5612());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3\n2\n2 3\n2 3\n4 1", "3"),
                Arguments.of("3\n2\n2 3\n2 4\n4 1", "0"),
                Arguments.of("3\n2\n2 3\n2 3\n1 0", "2"));

    }

}
