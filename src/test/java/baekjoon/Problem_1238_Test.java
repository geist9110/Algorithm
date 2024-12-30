package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1238_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1238());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4 8 2\n"
                + "1 2 4\n"
                + "1 3 2\n"
                + "1 4 7\n"
                + "2 1 1\n"
                + "2 3 5\n"
                + "3 1 2\n"
                + "3 4 4\n"
                + "4 2 3", "10")
        );
    }
}