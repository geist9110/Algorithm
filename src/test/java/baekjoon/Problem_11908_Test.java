package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_11908_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11908());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2\n3 4", "3"),
                Arguments.of("3\n1 3 5", "4"),
                Arguments.of("20\n1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", "190"));
    }

}
