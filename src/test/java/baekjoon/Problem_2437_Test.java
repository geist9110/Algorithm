package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2437_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2437());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("7\n3 1 6 2 7 30 1", "21"),
                Arguments.of("7\n3 1 6 2 7 21 1", "42"),
                Arguments.of("5\n1 1 1 1 1", "6"),
                Arguments.of("3\n1 2 4", "8"),
                Arguments.of("1\n2", "1"),
                Arguments.of("3\n2 3 4", "1"),
                Arguments.of("3\n1 3 4", "2")

        );
    }
}
