package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_11728_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11728());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2 2\n3 5\n2 9", "2 3 5 9"),
                Arguments.of("2 1\n4 7\n1", "1 4 7"),
                Arguments.of("4 3\n2 3 5 9\n1 4 7", "1 2 3 4 5 7 9"));
    }
}
