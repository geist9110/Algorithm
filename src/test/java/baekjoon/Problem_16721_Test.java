package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_16721_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16721());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4\n"
                    + "0 - - +\n"
                    + "- 0 + -\n"
                    + "- + 0 -\n"
                    + "+ - - 0\n"
                    + "2\n"
                    + "0 3\n"
                    + "3 2", "+\n-"
            )
        );
    }
}