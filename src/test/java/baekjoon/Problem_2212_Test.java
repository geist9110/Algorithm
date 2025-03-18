package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2212_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2212());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("6\n2\n1 6 9 3 6 7", "5"),
                Arguments.of("10\n5\n20 3 14 6 7 8 18 10 12 15", "7"),
                Arguments.of("6\n7\n1 6 9 3 6 7", "0"),
                Arguments.of("4\n2\n1 5 9 12", "7")

        );
    }
}
