package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10774_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10774());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4\n"
                    + "3\n"
                    + "M\n"
                    + "S\n"
                    + "S\n"
                    + "L\n"
                    + "L 3\n"
                    + "S 3\n"
                    + "L 1", "1"
            )
        );
    }
}