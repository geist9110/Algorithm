package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_15654_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15654());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("3 1\n"
                + "4 5 2", "2\n"
                + "4\n"
                + "5"),
            Arguments.of("4 2\n"
                + "9 8 7 1", "1 7\n"
                + "1 8\n"
                + "1 9\n"
                + "7 1\n"
                + "7 8\n"
                + "7 9\n"
                + "8 1\n"
                + "8 7\n"
                + "8 9\n"
                + "9 1\n"
                + "9 7\n"
                + "9 8"),
            Arguments.of("4 4\n"
                + "1231 1232 1233 1234", "1231 1232 1233 1234\n"
                + "1231 1232 1234 1233\n"
                + "1231 1233 1232 1234\n"
                + "1231 1233 1234 1232\n"
                + "1231 1234 1232 1233\n"
                + "1231 1234 1233 1232\n"
                + "1232 1231 1233 1234\n"
                + "1232 1231 1234 1233\n"
                + "1232 1233 1231 1234\n"
                + "1232 1233 1234 1231\n"
                + "1232 1234 1231 1233\n"
                + "1232 1234 1233 1231\n"
                + "1233 1231 1232 1234\n"
                + "1233 1231 1234 1232\n"
                + "1233 1232 1231 1234\n"
                + "1233 1232 1234 1231\n"
                + "1233 1234 1231 1232\n"
                + "1233 1234 1232 1231\n"
                + "1234 1231 1232 1233\n"
                + "1234 1231 1233 1232\n"
                + "1234 1232 1231 1233\n"
                + "1234 1232 1233 1231\n"
                + "1234 1233 1231 1232\n"
                + "1234 1233 1232 1231")
        );
    }
}