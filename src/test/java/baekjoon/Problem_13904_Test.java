package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_13904_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_13904());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("7\n4 60\n4 40\n1 20\n2 50\n3 30\n4 10\n6 5", "185")
        );
    }
}