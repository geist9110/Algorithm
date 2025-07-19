package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2121_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2121());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "6\n"
                    + "2 3\n"
                    + "0 0\n"
                    + "2 0\n"
                    + "2 3\n"
                    + "0 3\n"
                    + "4 0\n"
                    + "4 3", "2"
            )
        );
    }
}