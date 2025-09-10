package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10448_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10448());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n"
                + "10\n"
                + "20\n"
                + "1000", "1\n"
                + "0\n"
                + "1"),
            Arguments.of(
                "3\n"
                    + "911\n"
                    + "10\n"
                    + "938\n", "1\n"
                    + "1\n"
                    + "1\n"
            )
        );
    }
}