package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1865_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1865());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2\n"
                + "3 3 1\n"
                + "1 2 2\n"
                + "1 3 4\n"
                + "2 3 1\n"
                + "3 1 3\n"
                + "3 2 1\n"
                + "1 2 3\n"
                + "2 3 4\n"
                + "3 1 8", "NO\nYES")
        );
    }
}