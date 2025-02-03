package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1535_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1535());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3\n1 21 79\n20 30 25", "50"),
                Arguments.of("1\n100\n20", "0"),
                Arguments.of("8\n100 15 1 2 3 4 6 5\n49 40 1 2 3 4 5 4", "59"),
                Arguments.of("4\n100 50 20 13\n20 30 40 50", "120"),
                Arguments.of("8\n100 26 13 17 24 33 100 99\n34 56 21 1 24 34 100 99", "135"),
                Arguments.of(
                        "12\n1 1 1 1 1 1 1 1 1 1 1 1\n100 100 100 100 100 100 100 100 100 100 100 100",
                        "1200"),
                Arguments.of("3\n0 0 0\n1 2 3", "6"),
                Arguments.of("3\n0 100 0\n1 2 3", "4"),
                Arguments.of("4\n0 100 0 2\n1 2 3 10", "14"));
    }
}
