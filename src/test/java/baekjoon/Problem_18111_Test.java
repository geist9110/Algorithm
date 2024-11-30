package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_18111_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_18111());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3 4 99\n"
                + "0 0 0 0\n"
                + "0 0 0 0\n"
                + "0 0 0 1", "2 0"),
            Arguments.of("3 4 1\n"
                + "64 64 64 64\n"
                + "64 64 64 64\n"
                + "64 64 64 63", "1 64"),
            Arguments.of("3 4 0\n"
                + "64 64 64 64\n"
                + "64 64 64 64\n"
                + "64 64 64 63", "22 63")
        );
    }
}