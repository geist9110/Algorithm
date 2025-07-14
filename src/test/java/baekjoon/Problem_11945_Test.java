package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_11945_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11945());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5 7\n"
                + "0010000\n"
                + "0111010\n"
                + "1111111\n"
                + "0111010\n"
                + "0010000", "0000100\n"
                + "0101110\n"
                + "1111111\n"
                + "0101110\n"
                + "0000100")
        );
    }
}