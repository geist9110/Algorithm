package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_16951_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16951());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4 1\n"
                    + "1 1 4 5", "2"
            ),
            Arguments.of(
                "4 1\n"
                    + "1 2 1 5", "2"
            ),
            Arguments.of(
                "4 1\n"
                    + "1 2 3 4", "0"
            ),
            Arguments.of(
                "5 1\n"
                    + "1 2 1 5 5", "2"
            )
        );
    }
}