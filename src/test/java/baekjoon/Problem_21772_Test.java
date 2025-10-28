package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Problem_21772_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_21772());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "11 11 5\n"
                    + "........G..\n"
                    + "......S.#S.\n"
                    + "........#.S\n"
                    + "...........\n"
                    + "...........\n"
                    + ".##########\n"
                    + ".##########\n"
                    + "...........\n"
                    + "...........\n"
                    + "##########.\n"
                    + "...........",
                "2"),
            Arguments.of(
                "11 11 5\n"
                    + "G....S.....\n"
                    + "...........\n"
                    + "...........\n"
                    + "...........\n"
                    + "...........\n"
                    + "...........\n"
                    + ".....#.....\n"
                    + "...........\n"
                    + "...........\n"
                    + "...........\n"
                    + "...........",
                "1"),
                Arguments.of("2 4 5\n.#S#\n.SGS", "3"));
    }
}
