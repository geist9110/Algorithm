package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10101_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10101());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("60\n70\n50", "Scalene"),
            Arguments.of("60\n60\n60", "Equilateral"),
            Arguments.of("45\n90\n45", "Isosceles"),
            Arguments.of("45\n80\n45", "Error")
        );
    }
}