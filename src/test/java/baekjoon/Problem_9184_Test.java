package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_9184_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_9184());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("1 1 1\n2 2 2\n10 4 6\n50 50 50\n-1 7 18\n-1 -1 -1",
                        "w(1, 1, 1) = 2\nw(2, 2, 2) = 4\nw(10, 4, 6) = 523\nw(50, 50, 50) = 1048576\nw(-1, 7, 18) = 1"),
                Arguments.of("50 50 0\n-1 -1 -1", "w(50, 50, 0) = 1"));
    }
}
