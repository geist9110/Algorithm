package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10817_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10817());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("20 30 10", "20"),
            Arguments.of("30 30 10", "30"),
            Arguments.of("40 40 40", "40"),
            Arguments.of("20 10 10", "10")
        );
    }
}