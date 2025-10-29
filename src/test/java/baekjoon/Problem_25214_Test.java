package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_25214_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25214());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("6\n50 100 70 110 10 100", "0 50 50 60 60 90"),
                Arguments.of("6\n3 3 2 8 3 1000000000", "0 0 0 6 6 999999998"));
    }
}
