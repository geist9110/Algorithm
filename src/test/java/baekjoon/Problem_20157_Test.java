package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_20157_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_20157());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("""
                5
                8 16
                10 -3
                2 4
                7 10
                1 2""", "3"),
            Arguments.of("""
                10
                -14 -3
                4 8
                3 14
                7 -14
                21 -42
                -3 18
                -7 -7
                12 24
                20 -40
                1 9""", "3")
        );
    }
}