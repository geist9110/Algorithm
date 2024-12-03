package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1389_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1389());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 5\n"
                + "1 3\n"
                + "1 4\n"
                + "4 5\n"
                + "4 3\n"
                + "3 2", "3")
        );
    }
}