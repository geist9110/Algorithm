package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_14503_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14503());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 3\n1 1 0\n1 1 1\n1 0 1\n1 1 1", "1"),
                Arguments.of(
                        "11 10\n" + //
                                "7 4 0\n" + //
                                "1 1 1 1 1 1 1 1 1 1\n" + //
                                "1 0 0 0 0 0 0 0 0 1\n" + //
                                "1 0 0 0 1 1 1 1 0 1\n" + //
                                "1 0 0 1 1 0 0 0 0 1\n" + //
                                "1 0 1 1 0 0 0 0 0 1\n" + //
                                "1 0 0 0 0 0 0 0 0 1\n" + //
                                "1 0 0 0 0 0 0 1 0 1\n" + //
                                "1 0 0 0 0 0 1 1 0 1\n" + //
                                "1 0 0 0 0 0 1 1 0 1\n" + //
                                "1 0 0 0 0 0 0 0 0 1\n" + //
                                "1 1 1 1 1 1 1 1 1 1",
                        "57"));
    }
}
