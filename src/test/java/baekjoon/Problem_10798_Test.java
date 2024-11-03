package baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10798_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10798());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("ABCDE\n"
                + "abcde\n"
                + "01234\n"
                + "FGHIJ\n"
                + "fghij", "Aa0FfBb1GgCc2HhDd3IiEe4Jj"),
            Arguments.of("AABCDD\n"
                + "afzz\n"
                + "09121\n"
                + "a8EWg6\n"
                + "P5h3kx", "Aa0aPAf985Bz1EhCz2W3D1gkD6x")
        );
    }
}