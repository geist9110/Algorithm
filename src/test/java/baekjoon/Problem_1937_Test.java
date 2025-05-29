package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1937_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1937());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("4\n"
                + "14 9 12 10\n"
                + "1 11 5 4\n"
                + "7 15 2 13\n"
                + "6 3 16 8", "4"
            )
        );
    }
}