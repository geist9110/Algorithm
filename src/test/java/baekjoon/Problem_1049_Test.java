package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_1049_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1049());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("4 2\n12 3\n15 4", "12"),
                Arguments.of("10 3\n20 8\n40 7\n60 4", "36"),
                Arguments.of("15 1\n100 40", "300"),
                Arguments.of("17 1\n12 3", "36"),
                Arguments.of("7 2\n10 3\n12 2", "12"),
                Arguments.of(
                        "9 16\n21 25\n77 23\n23 88\n95 43\n96 19\n59 36\n80 13\n51 24\n15 8\n25 61\n21 22\n3 9\n68 68\n67 100\n83 98\n96 57",
                        "6")

        );
    }
}
