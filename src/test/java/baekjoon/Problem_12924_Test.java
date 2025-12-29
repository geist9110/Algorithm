package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_12924_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_12924());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("1 9", "0"),
                Arguments.of("10 40", "3"),
                Arguments.of("100 500", "156"));
    }

}
