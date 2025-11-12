package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1980_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1980());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 5 55", "17 0"),
                Arguments.of("3 5 54", "18 0"),
                Arguments.of("3 5 7", "2 1"),
                Arguments.of("3 5 8", "2 0"));
    }

}
