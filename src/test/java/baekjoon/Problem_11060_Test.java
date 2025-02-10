package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_11060_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11060());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("10\n1 2 0 1 3 2 1 5 4 2", "5"),
                Arguments.of("5\n0 0 0 0 0", "-1"));
    }

}
