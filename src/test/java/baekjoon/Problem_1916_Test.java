package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1916_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1916());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\n"
                + "8\n"
                + "1 2 2\n"
                + "1 3 3\n"
                + "1 4 1\n"
                + "1 5 10\n"
                + "2 4 2\n"
                + "3 4 1\n"
                + "3 5 1\n"
                + "4 5 3\n"
                + "1 5", "4")
        );
    }
}