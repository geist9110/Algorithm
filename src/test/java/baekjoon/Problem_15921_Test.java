package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_15921_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15921());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n5 10 10 15 20", "1.00"),
                Arguments.of("0", "divide by zero"),
                Arguments.of("1\n0", "divide by zero"));
    }

}
