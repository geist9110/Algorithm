package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_6417_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_6417());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "25\n"
                    + "30\n"
                    + "3121\n"
                    + "-1", "25 coconuts, 3 people and 1 monkey\n"
                    + "30 coconuts, no solution\n"
                    + "3121 coconuts, 5 people and 1 monkey"
            ),
            Arguments.of("1\n"
                + "-1", "1 coconuts, no solution")
        );
    }
}