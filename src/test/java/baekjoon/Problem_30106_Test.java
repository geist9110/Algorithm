package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_30106_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_30106());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "2 3 2\n"
                    + "5 4 6\n"
                    + "4 7 2", "3"
            )
        );
    }
}