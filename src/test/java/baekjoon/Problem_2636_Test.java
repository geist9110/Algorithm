package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2636_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2636());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("13 12\n" + "0 0 0 0 0 0 0 0 0 0 0 0\n" + "0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 1 1 0 0 0\n" + "0 1 1 1 0 0 0 1 1 0 0 0\n"
                        + "0 1 1 1 1 1 1 0 0 0 0 0\n" + "0 1 1 1 1 1 0 1 1 0 0 0\n"
                        + "0 1 1 1 1 0 0 1 1 0 0 0\n" + "0 0 1 1 0 0 0 1 1 0 0 0\n"
                        + "0 0 1 1 1 1 1 1 1 0 0 0\n" + "0 0 1 1 1 1 1 1 1 0 0 0\n"
                        + "0 0 1 1 1 1 1 1 1 0 0 0\n" + "0 0 1 1 1 1 1 1 1 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0", "3\n5"),
                Arguments.of("5 5\n" + "0 0 0 0 0\n" + "0 1 1 1 0\n" + "0 1 0 1 0\n" + "0 1 1 1 0\n"
                        + "0 0 0 0 0", "1\n8"),
                Arguments.of(
                        "10 12\n" + "0 0 0 0 0 0 0 0 0 0 0 0\n" + "0 1 1 1 1 1 1 1 1 1 1 0\n"
                                + "0 1 1 0 0 1 0 0 0 1 1 0\n" + "0 1 0 1 0 1 0 1 1 0 1 0\n"
                                + "0 1 0 1 0 1 0 0 0 0 0 0\n" + "0 1 0 1 0 0 1 1 1 0 1 0\n"
                                + "0 1 0 1 1 1 1 1 1 0 1 0\n" + "0 1 0 0 0 0 0 0 0 0 1 0\n"
                                + "0 1 1 1 1 1 1 1 1 1 1 0\n" + "0 0 0 0 0 0 0 0 0 0 0 0",
                        "1\n50"));
    }


}
