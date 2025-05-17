package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14891_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14891());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("10101111\n"
                + "01111101\n"
                + "11001110\n"
                + "00000010\n"
                + "2\n"
                + "3 -1\n"
                + "1 1", "7"),
            Arguments.of("11111111\n"
                + "11111111\n"
                + "11111111\n"
                + "11111111\n"
                + "3\n"
                + "1 1\n"
                + "2 1\n"
                + "3 1", "15"),
            Arguments.of("10001011\n"
                + "10000011\n"
                + "01011011\n"
                + "00111101\n"
                + "5\n"
                + "1 1\n"
                + "2 1\n"
                + "3 1\n"
                + "4 1\n"
                + "1 -1", "6"),
            Arguments.of("10010011\n"
                + "01010011\n"
                + "11100011\n"
                + "01010101\n"
                + "8\n"
                + "1 1\n"
                + "2 1\n"
                + "3 1\n"
                + "4 1\n"
                + "1 -1\n"
                + "2 -1\n"
                + "3 -1\n"
                + "4 -1", "5")
        );
    }
}