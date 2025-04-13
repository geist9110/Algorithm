package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1358_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1358());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("20 10 5 0 3\n"
                + "15 5\n"
                + "1 5\n"
                + "1 1", "2"),
            Arguments.of("20 10 0 0 14\n"
                + "-5 5\n"
                + "-4 2\n"
                + "-4 8\n"
                + "-3 1\n"
                + "-3 9\n"
                + "0 0\n"
                + "0 10\n"
                + "20 0\n"
                + "20 10\n"
                + "23 1\n"
                + "23 9\n"
                + "24 2\n"
                + "24 8\n"
                + "25 5", "14"),
            Arguments.of("52 84 -44 66 10\n"
                + "26 118\n"
                + "-33 106\n"
                + "-49 128\n"
                + "40 114\n"
                + "-10 101\n"
                + "47 85\n"
                + "25 142\n"
                + "-16 140\n"
                + "-82 126\n"
                + "7 145", "8"),
            Arguments.of("24 100 -62 71 8\n"
                + "-63 109\n"
                + "-26 164\n"
                + "-9 91\n"
                + "-113 80\n"
                + "-124 75\n"
                + "-95 140\n"
                + "-89 116\n"
                + "-55 113", "6")
        );
    }
}