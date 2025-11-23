package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_30205_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_30205());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 5 10\n30 7 -1 0 10\n10 10 10 10 1\n200 -1 0 0 0", "1"),
                Arguments.of("3 5 1\n30 7 -1 0 10\n10 10 10 10 1\n 200 -1 0 0 0", "0"),
                Arguments.of("2 5 1\n-1 -1 -1 -1 -1\n-1 -1 -1 -1 512", "1"),
                Arguments.of("2 5 1\n-1 -1 -1 -1 -1\n-1 -1 -1 -1 513", "0"));
    }

}
