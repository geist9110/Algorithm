package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_9506_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_9506());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "6\n"
                    + "12\n"
                    + "28\n"
                    + "-1",
                "6 = 1 + 2 + 3\n"
                    + "12 is NOT perfect.\n"
                    + "28 = 1 + 2 + 4 + 7 + 14"
            )
        );
    }
}