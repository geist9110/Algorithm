package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_4963_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_4963());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                "1 1\n" +
                "0\n" +
                "2 2\n" +
                "0 1\n" +
                "1 0\n" +
                "3 2\n" +
                "1 1 1\n" +
                "1 1 1\n" +
                "5 4\n" +
                "1 0 1 0 0\n" +
                "1 0 0 0 0\n" +
                "1 0 1 0 1\n" +
                "1 0 0 1 0\n" +
                "5 4\n" +
                "1 1 1 0 1\n" +
                "1 0 1 0 1\n" +
                "1 0 1 0 1\n" +
                "1 0 1 1 1\n" +
                "5 5\n" +
                "1 0 1 0 1\n" +
                "0 0 0 0 0\n" +
                "1 0 1 0 1\n" +
                "0 0 0 0 0\n" +
                "1 0 1 0 1\n" +
                "0 0", "0\n" +
                "1\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "9"
            )
        );
    }
}
