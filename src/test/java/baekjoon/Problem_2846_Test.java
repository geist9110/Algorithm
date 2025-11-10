package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2846_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2846());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n1 2 1 4 6", "5"),
                Arguments.of("8\n12 20 1 3 4 4 11 1", "8"),
                Arguments.of("6\n10 8 8 6 4 3", "0"));
    }

}
