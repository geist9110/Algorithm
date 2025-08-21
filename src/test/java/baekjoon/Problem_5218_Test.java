package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_5218_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5218());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "5\n"
                    + "AAAA ABCD\n"
                    + "ABCD AAAA\n"
                    + "DARK LOKI\n"
                    + "STRONG THANOS\n"
                    + "DEADLY ULTIMO", "Distances: 0 1 2 3\n"
                    + "Distances: 0 25 24 23\n"
                    + "Distances: 8 14 19 24\n"
                    + "Distances: 1 14 9 25 1 12\n"
                    + "Distances: 17 7 19 5 1 16"
            )
        );
    }
}