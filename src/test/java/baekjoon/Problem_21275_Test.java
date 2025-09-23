package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_21275_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_21275());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("0 0", "Multiple"),
            Arguments.of("ep jh", "473 32 24"),
            Arguments.of("z z", "Impossible"),
            Arguments.of(
                "2222222222222222222222222222222222222222222222222222222222222222222222 8888888888888888888888888888888",
                "Impossible"
            )
        );
    }
}