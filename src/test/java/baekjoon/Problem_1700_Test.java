package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1700_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1700());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2 7\n2 3 2 3 1 2 7", "2"),
                Arguments.of("2 7\n2 3 1 7 2 3 2", "3"),
                Arguments.of("2 3\n1 1 2", "0"),
                Arguments.of("2 7\n2 3 2 3 1 1 3", "1"),
                Arguments.of(
                        "3 100\n56 71 70 25 52 77 76 8 68 71 51 65 13 23 7 16 19 54 95 18 86 74 29 76 61 93 44 96 32 72 64 19 50 49 22 14 7 64 24 83 6 3 2 76 99 7 76 100 60 60 6 50 90 49 27 51 37 61 16 84 89 51 73 28 90 77 73 39 78 96 78 13 92 54 70 69 62 78 7 75 30 67 97 98 19 86 90 90 2 39 41 58 57 84 19 8 52 39 26 7",
                        "80"),
                Arguments.of("2 9\n1 2 3 1 2 3 1 2 3", "4")

        );
    }
}
