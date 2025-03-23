package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1052_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1052());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 1", "1"),
                Arguments.of("13 2", "3"),
                Arguments.of("1000000 5", "15808"),
                Arguments.of("32 1", "0"),
                Arguments.of("64 1", "0"),
                Arguments.of("5 2", "0")

        );
    }
}
