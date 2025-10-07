package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_31861_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_31861());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("24 4", "16"),
            Arguments.of("17 6", "124698"),
            Arguments.of("0 2", "676")
        );
    }
}