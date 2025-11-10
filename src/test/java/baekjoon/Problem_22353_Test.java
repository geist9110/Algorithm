package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_22353_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_22353(), 1e-6);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("1 50 50", "1.6250000"),
                Arguments.of("15 3 7", "226.3344692"),
                Arguments.of("100 50 50", "162.5"));
    }

}
