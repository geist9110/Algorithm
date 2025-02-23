package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_15486_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15486());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("7\n3 10\n5 20\n1 10\n1 20\n2 15\n4 40\n2 200", "45"),
                Arguments.of("10\n1 1\n1 2\n1 3\n1 4\n1 5\n1 6\n1 7\n1 8\n1 9\n1 10", "55"),
                Arguments.of("10\n5 10\n5 9\n5 8\n5 7\n5 6\n5 10\n5 9\n5 8\n5 7\n5 6", "20"),
                Arguments.of("10\n5 50\n4 40\n3 30\n2 20\n1 10\n1 10\n2 20\n3 30\n4 40\n5 50",
                        "90"));
    }
}
