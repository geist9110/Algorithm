package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_8911_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_8911());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "3\n"
                    + "FFLF\n"
                    + "FFRRFF\n"
                    + "FFFBBBRFFFBBB", "2\n"
                    + "0\n"
                    + "9"
            ),
            Arguments.of("1\n"
                + "LFLLFLF", "1"),
            Arguments.of("1\n"
                + "RFRF", "1")
        );
    }
}