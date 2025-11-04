package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_11283_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11283());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("가", "1"),
                Arguments.of("힣", "11172"),
                Arguments.of("백", "4146"),
                Arguments.of("준", "7425"));
    }
}
