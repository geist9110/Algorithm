package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_4179_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_4179());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4 4\n"
                + "####\n"
                + "#JF#\n"
                + "#..#\n"
                + "#..#", "3"),
            Arguments.of("4 4\n"
                + "####\n"
                + "#J.#\n"
                + "##.#\n"
                + "##.#\n", "4"),
            Arguments.of("1 3\n"
                + "F#J", "1"),
            Arguments.of("5 4\n"
                + "#FFF\n"
                + "#.F.\n"
                + ".F.F\n"
                + ".FJ#\n"
                + "....", "2"),
            Arguments.of("3 3\n"
                + "###\n"
                + "#J#\n"
                + "#.#", "2"),
            Arguments.of("4 4\n"
                + "####\n"
                + "#JF#\n"
                + "####\n"
                + "#.F#", "IMPOSSIBLE"),
            Arguments.of("2 2\n"
                + "##\n"
                + "JF", "1"),
            Arguments.of("3 3\n"
                + "###\n"
                + "#J.\n"
                + "#.F", "IMPOSSIBLE")
        );
    }
}