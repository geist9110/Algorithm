package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14936_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14936());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 5 4\n"
                + "5 7 8 2 3\n"
                + "1 4 5\n"
                + "5 2 4\n"
                + "3 2 3\n"
                + "1 2 3", "23")
        );
    }
}