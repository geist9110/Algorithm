package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_27162_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27162());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "YYYYYYYYYYYN\n"
                    + "1 5 6", "18"
            ),
            Arguments.of(
                "YYYYYYYYYYYY\n"
                    + "4 4 4", "50"
            ),
            Arguments.of(
                "NNNNYNNNNYNN\n"
                    + "6 6 1", "10"
            ),
            Arguments.of(
                "YNNYYNYNYNYY\n"
                    + "1 3 1", "17"
            ),
            Arguments.of(
                "YYYYYNYYNYNN\n"
                    + "4 5 1", "15"
            ),
            Arguments.of(
                "YNNNNNNNNNNN\n"
                    + "1 1 1", "5"
            ),
            Arguments.of(
                "YNNNNNNNNNNN\n"
                    + "2 2 2", "2"
            ),
            Arguments.of(
                "NNNNNNYNNNNN\n"
                    + "1 1 1", "4"
            )
        );
    }
}