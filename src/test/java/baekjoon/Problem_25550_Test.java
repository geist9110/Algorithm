package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_25550_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25550());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 3\n1 2 2\n1 2 2\n1 1 1", "1"),
                Arguments.of(
                        "4 4\n1000000000 1000000000 1000000000 1000000000\n1000000000 1000000000 1000000000 1000000000\n1000000000 1000000000 1000000000 1000000000\n1000000000 1000000000 1000000000 1000000000",
                        "3999999996"),
                Arguments.of(
                        "4 4\n1000000000 1000000000 1000000000 1000000000\n1000000000 1 2 1000000000\n1000000000 3 4 1000000000\n1000000000 1000000000 1000000000 1000000000",
                        "4"),
                Arguments.of("3 3\n7 7 7\n7 0 7\n7 7 7", "0"),
                Arguments.of("1 2\n5 5", "0"),
                Arguments.of("2 1\n5\n5", "0"));
    }

}
