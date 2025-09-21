package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_14381_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_14381());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4\n"
                    + "0\n"
                    + "1\n"
                    + "2\n"
                    + "11", "Case #1: INSOMNIA\n"
                    + "Case #2: 10\n"
                    + "Case #3: 90\n"
                    + "Case #4: 110"
            )
        );
    }
}