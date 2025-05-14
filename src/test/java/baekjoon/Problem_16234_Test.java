package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_16234_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16234());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2 20 50\n"
                + "50 30\n"
                + "20 40", "1"
            ),
            Arguments.of("2 40 50\n"
                + "50 30\n"
                + "20 40", "0"),
            Arguments.of("2 20 50\n"
                + "50 30\n"
                + "30 40", "1"),
            Arguments.of("3 5 10\n"
                + "10 15 20\n"
                + "20 30 25\n"
                + "40 22 10", "2"),
            Arguments.of("4 10 50\n"
                + "10 100 20 90\n"
                + "80 100 60 70\n"
                + "70 20 30 40\n"
                + "50 20 100 10", "3")
        );
    }
}