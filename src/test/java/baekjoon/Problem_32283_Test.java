package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_32283_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_32283());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n01101", "22"),
                Arguments.of("5\n00000", "0"),
                Arguments.of("5\n10000", "1"),
                Arguments.of("5\n01000", "2"),
                Arguments.of("5\n00100", "3"),
                Arguments.of("5\n00010", "4"),
                Arguments.of("5\n00001", "5"),
                Arguments.of("5\n11000", "6"),
                Arguments.of("5\n10100", "7"),
                Arguments.of("5\n01100", "8"),
                Arguments.of("5\n10010", "9"),
                Arguments.of("5\n01010", "10"),
                Arguments.of("5\n00110", "11"),
                Arguments.of("5\n10001", "12"),
                Arguments.of("5\n01001", "13"),
                Arguments.of("5\n00101", "14"),
                Arguments.of("5\n00011", "15"),
                Arguments.of("3\n000", "0"),
                Arguments.of("3\n100", "1"),
                Arguments.of("3\n010", "2"),
                Arguments.of("3\n001", "3"),
                Arguments.of("3\n110", "4"),
                Arguments.of("3\n101", "5"),
                Arguments.of("3\n011", "6"),
                Arguments.of("3\n111", "7"));
    }

}
