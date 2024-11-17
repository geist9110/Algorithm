package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10845_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10845());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("15\n"
                + "push 1\n"
                + "push 2\n"
                + "front\n"
                + "back\n"
                + "size\n"
                + "empty\n"
                + "pop\n"
                + "pop\n"
                + "pop\n"
                + "size\n"
                + "empty\n"
                + "pop\n"
                + "push 3\n"
                + "empty\n"
                + "front", "1\n"
                + "2\n"
                + "2\n"
                + "0\n"
                + "1\n"
                + "2\n"
                + "-1\n"
                + "0\n"
                + "1\n"
                + "-1\n"
                + "0\n"
                + "3")
        );
    }
}