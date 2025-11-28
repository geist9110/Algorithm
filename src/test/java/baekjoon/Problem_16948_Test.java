package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_16948_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16948());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("7\n6 6 0 1", "4"),
                Arguments.of("6\n5 1 0 5", "-1"),
                Arguments.of("7\n0 3 4 3", "2"));
    }

}
