package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1092_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1092());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("3\n6 8 9\n5\n2 5 2 4 7", "2"),
                Arguments.of("2\n19 20\n7\n14 12 16 19 16 1 5", "4"),
                Arguments.of("4\n23 32 25 28\n10\n5 27 10 16 24 20 2 32 18 7", "3"),
                Arguments.of("10\n11 17 5 2 20 7 5 5 20 7\n5\n18 18 15 15 17", "2"),
                Arguments.of("4\n3 5 7 10\n4\n1 1 1 1", "1"),
                Arguments.of("4\n3 5 7 10\n6\n1 2 3 9 9 9", "3")

        );
    }
}
