package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2056_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2056());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("7\n5 0\n1 1 1\n3 1 2\n6 1 1\n1 2 2 4\n8 2 2 4\n4 3 3 5 6", "23"));
    }
}
