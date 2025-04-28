package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_16937_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16937());
    }

    public static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "2 2\n"
                    + "2\n"
                    + "1 2\n"
                    + "2 1", "4"
            ),
            Arguments.of(
                "10 9\n"
                    + "4\n"
                    + "2 3\n"
                    + "1 1\n"
                    + "5 10\n"
                    + "9 11", "56"
            ),
            Arguments.of(
                "10 10\n"
                    + "3\n"
                    + "6 6\n"
                    + "7 7\n"
                    + "20 5", "0"
            ),
            Arguments.of(
                "40 100\n"
                    + "2\n"
                    + "51 35\n"
                    + "52 35", "0"
            ),
            Arguments.of(
                "80 95\n"
                    + "3\n"
                    + "50 90\n"
                    + "40 80\n"
                    + "55 80", "7600"
            ),
            Arguments.of(
                "5 10\n"
                    + "2\n"
                    + "5 11\n"
                    + "5 11", "0"
            ),
            Arguments.of(
                "13 16\n"
                    + "3\n"
                    + "7 6\n"
                    + "11 13\n"
                    + "11 4", "187"
            ),
            Arguments.of(
                "49 32\n"
                    + "3\n"
                    + "11 43\n"
                    + "16 23\n"
                    + "18 43", "1247"
            ),
            Arguments.of(
                "25 51\n"
                    + "4\n"
                    + "22 22\n"
                    + "27 12\n"
                    + "30 8\n"
                    + "29 20", "1064"
            ),
            Arguments.of(
                "11 17\n"
                    + "5\n"
                    + "12 4\n"
                    + "1 16\n"
                    + "1 9\n"
                    + "10 9\n"
                    + "8 8", "154"
            )
        );
    }
}