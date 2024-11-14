package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_5073_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5073());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7 7 7\n"
                + "6 5 4\n"
                + "3 2 5\n"
                + "6 2 6\n"
                + "0 0 0", "Equilateral\n"
                + "Scalene\n"
                + "Invalid\n"
                + "Isosceles")
        );
    }
}