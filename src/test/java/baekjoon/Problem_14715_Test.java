package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_14715_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14715());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2", "0"),
                Arguments.of("3", "0"),
                Arguments.of("4", "1"),
                Arguments.of("5", "0"),
                Arguments.of("6", "1"),
                Arguments.of("7", "0"),
                Arguments.of("8", "2"),
                Arguments.of("9", "1"),
                Arguments.of("10", "1"),
                Arguments.of("11", "0"),
                Arguments.of("12", "2"),
                Arguments.of("13", "0"),
                Arguments.of("14", "1"),
                Arguments.of("15", "1"),
                Arguments.of("16", "2"),
                Arguments.of("17", "0"),
                Arguments.of("18", "2"),
                Arguments.of("19", "0"),
                Arguments.of("20", "2"),
                Arguments.of("21", "1"),
                Arguments.of("22", "1"),
                Arguments.of("23", "0"),
                Arguments.of("100", "2"),
                Arguments.of("1000", "3"),
                Arguments.of("10000", "3"),
                Arguments.of("100000", "4"),
                Arguments.of("1000000", "4"),
                Arguments.of("524288", "5"),
                Arguments.of("24", "2"));
    }

}
