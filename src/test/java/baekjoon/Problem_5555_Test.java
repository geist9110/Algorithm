package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_5555_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5555());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "ABCD\n"
                    + "3\n"
                    + "ABCDXXXXXX\n"
                    + "YYYYABCDXX\n"
                    + "DCBAZZZZZZ",
                "2"
            ),
            Arguments.of(
                "XYZ\n"
                    + "1\n"
                    + "ZAAAAAAAXY",
                "1"
            ),
            Arguments.of(
                "PQR\n"
                    + "3\n"
                    + "PQRAAAAPQR\n"
                    + "BBPQRBBBBB\n"
                    + "CCCCCCCCCC",
                "2"
            )
        );
    }
}