package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_11722_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11722());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("6\n10 30 10 20 20 10", "3"),
                Arguments.of("1\n2", "1"),
                Arguments.of("5\n2 2 2 2 2", "1"),
                Arguments.of("5\n1 2 3 4 5", "1"),
                Arguments.of("5\n5 4 3 2 1", "5"),
                Arguments.of("6\n10 4 9 1 3 2", "4"),
                Arguments.of("3\n3 1 9\n", "2")

        );
    }

}
