package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14400_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14400());
    }

    public static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "5\n"
                    + "2 2\n"
                    + "3 4\n"
                    + "5 6\n"
                    + "1 9\n"
                    + "-2 -8", "30"
            )
        );
    }
}