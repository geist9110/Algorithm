package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_25116_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25116());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 20 5\n4 0 4", "16"),
                Arguments.of("5 30 4\n1 2 3 4 5", "6"),
                Arguments.of("4 32 4\n8 7 5 9", "9"));
    }

}
