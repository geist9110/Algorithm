package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_7662_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_7662());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2\n"
                + "7\n"
                + "I 16\n"
                + "I -5643\n"
                + "D -1\n"
                + "D 1\n"
                + "D 1\n"
                + "I 123\n"
                + "D -1\n"
                + "9\n"
                + "I -45\n"
                + "I 653\n"
                + "D 1\n"
                + "I -642\n"
                + "I 45\n"
                + "I 97\n"
                + "D 1\n"
                + "D -1\n"
                + "I 333", "EMPTY\n"
                + "333 -45")
        );
    }
}