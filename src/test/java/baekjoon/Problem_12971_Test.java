package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_12971_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_12971());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("20 20 20 1 2 3", "-1"),
                Arguments.of("2 3 5 1 1 1", "1"),
                Arguments.of("2 4 8 1 2 3", "-1"),
                Arguments.of("2 3 5 1 2 3", "23"),
                Arguments.of("281 283 293 280 282 289", "21550732"),
                Arguments.of("281 283 300 280 282 299", "23856899"));
    }

}
