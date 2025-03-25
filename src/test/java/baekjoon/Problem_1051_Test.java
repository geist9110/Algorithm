package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1051_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1051());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 5\n" + //
                        "42101\n" + //
                        "22100\n" + //
                        "22101", "9"),
                Arguments.of("2 2\n" + //
                        "12\n" + //
                        "34", "1"),
                Arguments.of("2 4\n" + //
                        "1255\n" + //
                        "3455", "4"),
                Arguments.of("1 10\n" + //
                        "1234567890", "1"),
                Arguments.of("11 10\n" + //
                        "9785409507\n" + //
                        "2055103694\n" + //
                        "0861396761\n" + //
                        "3073207669\n" + //
                        "1233049493\n" + //
                        "2300248968\n" + //
                        "9769239548\n" + //
                        "7984130001\n" + //
                        "1670020095\n" + //
                        "8894239889\n" + //
                        "4053971072", "49"));
    }
}
