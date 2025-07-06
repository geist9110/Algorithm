package baekjoon;

import java.io.IOException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class Problem_29751_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_29751());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("1 1", "0.5"), Arguments.of("2 3", "3.0"));
    }
}
