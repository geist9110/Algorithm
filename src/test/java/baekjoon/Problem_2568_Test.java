package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2568_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2568());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("8\n1 8\n3 9\n2 2\n4 1\n6 4\n10 10\n9 7\n7 6", "3\n1\n2\n3"),
            Arguments.of("3\n10 50\n20 20\n30 60", "1\n10")
        );
    }
}