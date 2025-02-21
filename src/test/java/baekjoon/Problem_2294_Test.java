package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2294_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2294());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3 15\n1\n5\n12", "3"),
                Arguments.of("2 19\n5\n7", "3")

        );
    }
}
