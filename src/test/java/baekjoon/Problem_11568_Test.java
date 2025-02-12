package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_11568_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11568());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n8 9 1 2 10", "3"),
                Arguments.of("8\n5 4 3 2 1 6 7 8", "4"),
                Arguments.of("8\n1 2 3 4 5 6 7 8", "8"),
                Arguments.of("8\n8 8 8 8 8 8 8 8", "1"),
                Arguments.of("8\n8 7 6 5 4 3 2 1", "1"),
                Arguments.of("5\n1 4 2 4 5", "4"),
                Arguments.of("1\n1", "1")

        );
    }

}
