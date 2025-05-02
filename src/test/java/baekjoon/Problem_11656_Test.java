package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_11656_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_11656());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("baekjoon", "aekjoon\nbaekjoon\nekjoon\njoon\nkjoon\nn\non\noon")
        );
    }
}