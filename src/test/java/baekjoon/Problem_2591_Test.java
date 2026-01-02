package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2591_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2591());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("27123", "6"),
                Arguments.of("1024", "2"),
                Arguments.of("1010", "1"),
                Arguments.of("10111", "3"),
                Arguments.of("110", "1"));
    }

}
