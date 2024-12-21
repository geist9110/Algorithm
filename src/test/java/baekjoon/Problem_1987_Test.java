package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1987_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1987());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2 4\n"
                + "CAAB\n"
                + "ADCB", "3"),
            Arguments.of("3 6\n"
                + "HFDFFB\n"
                + "AJHGDH\n"
                + "DGAGEH", "6"),
            Arguments.of("5 5\n"
                + "IEFCJ\n"
                + "FHFKC\n"
                + "FFALF\n"
                + "HFGCF\n"
                + "HMCHH", "10")
        );
    }
}