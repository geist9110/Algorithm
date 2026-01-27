package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_14910_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14910());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("7", "Good"),
                Arguments.of("1 2 3 4 5", "Good"),
                Arguments.of("1 2 2 2 4", "Good"),
                Arguments.of("2 1", "Bad"),
                Arguments.of("1 2 3 2 1", "Bad"));
    }

}
