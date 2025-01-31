package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2876_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2876());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("1\n1 5", "1 1"),
                Arguments.of("3\n3 5\n4 5\n1 3", "2 5"),
                Arguments.of("4\n2 1\n3 2\n5 3\n2 5", "2 2"));
    }
}
