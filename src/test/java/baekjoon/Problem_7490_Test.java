package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_7490_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_7490());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2\n"
                + "3\n"
                + "7", "1+2-3\n"
                + "\n"
                + "1+2-3+4-5-6+7\n"
                + "1+2-3-4+5+6-7\n"
                + "1-2 3+4+5+6+7\n"
                + "1-2 3-4 5+6 7\n"
                + "1-2+3+4-5+6-7\n"
                + "1-2-3-4-5+6+7")
        );
    }
}