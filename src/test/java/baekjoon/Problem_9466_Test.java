package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_9466_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_9466());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("2\n7\n3 1 3 7 3 4 6\n8\n1 2 3 4 5 6 7 8", "3\n0"));
    }

}
