package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_9465_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_9465());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2\n"
                + "5\n"
                + "50 10 100 20 40\n"
                + "30 50 70 10 60\n"
                + "7\n"
                + "10 30 10 50 100 20 40\n"
                + "20 40 30 50 60 20 80", "260\n"
                + "290")
        );
    }
}