package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14428_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14428());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\n"
                + "5 4 3 2 1\n"
                + "6\n"
                + "2 1 3\n"
                + "2 1 4\n"
                + "1 5 3\n"
                + "2 3 5\n"
                + "1 4 3\n"
                + "2 3 5", "3\n"
                + "4\n"
                + "4\n"
                + "3")
        );
    }
}