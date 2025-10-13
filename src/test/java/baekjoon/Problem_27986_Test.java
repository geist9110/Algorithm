package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_27986_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27986());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "3 1\n"
                    + "1 3", "1 2 3"
            ),
            Arguments.of(
                "3 2\n"
                    + "1 2\n"
                    + "2 3", "1 2 1"
            )
        );
    }
}