package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_18869_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_18869());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2 3\n1 3 2\n12 50 31", "1"),
                Arguments.of("2 3\n1 3 2\n12 50 10", "0"),
                Arguments.of("5 3\n20 10 30\n10 20 60\n80 25 79\n30 50 80\n80 25 81", "2"),
                Arguments.of("2 3\n40 10 10\n30 10 20", "0"),
                Arguments.of("2 4\n1 3 3 1\n1 3 2 1", "0"),
                Arguments.of("3 3\n1 2 3\n1 2 3\n2 3 4", "3"),
                Arguments.of("2 5\n1 1 2 6 8\n1 1 4 6 9", "1"),
                Arguments.of("2 5\n1 3 4 1 1\n1 3 4 1 2", "0"));
    }

}
