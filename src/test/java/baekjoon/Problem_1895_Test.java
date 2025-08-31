package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1895_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1895());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "6 5\n"
                    + "49 36 73 62 21\n"
                    + "27 88 14 11 12\n"
                    + "99 18 36 91 21\n"
                    + "45 96 72 12 10\n"
                    + "12 48 49 75 56\n"
                    + "12 15 48 86 78\n"
                    + "40", "7"
            )
        );
    }
}