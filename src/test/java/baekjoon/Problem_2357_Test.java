package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2357_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2357());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "10 4\n"
                    + "75\n"
                    + "30\n"
                    + "100\n"
                    + "38\n"
                    + "50\n"
                    + "51\n"
                    + "52\n"
                    + "20\n"
                    + "81\n"
                    + "5\n"
                    + "1 10\n"
                    + "3 5\n"
                    + "6 9\n"
                    + "8 10", "5 100\n"
                    + "38 100\n"
                    + "20 81\n"
                    + "5 81"
            ),
            Arguments.of("5 6\n"
                + "20\n"
                + "32\n"
                + "20\n"
                + "90\n"
                + "18\n"
                + "2 2\n"
                + "2 4\n"
                + "1 5\n"
                + "1 3\n"
                + "1 1\n"
                + "1 5\n", "32 32\n"
                + "20 90\n"
                + "18 90\n"
                + "20 32\n"
                + "20 20\n"
                + "18 90\n")
        );
    }
}