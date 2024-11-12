package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_9063_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_9063());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3\n"
                + "20 24\n"
                + "40 21\n"
                + "10 12", "360"),
            Arguments.of("1\n"
                + "15 13", "0"),
            Arguments.of("4\n"
                + "2 1\n"
                + "3 2\n"
                + "5 2\n"
                + "3 4", "9")
        );
    }
}