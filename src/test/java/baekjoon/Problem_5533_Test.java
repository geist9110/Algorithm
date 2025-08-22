package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_5533_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5533());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "5\n"
                    + "100 99 98\n"
                    + "100 97 92\n"
                    + "63 89 63\n"
                    + "99 99 99\n"
                    + "89 97 98", "0\n"
                    + "92\n"
                    + "215\n"
                    + "198\n"
                    + "89"
            ),
            Arguments.of(
                "3\n"
                    + "89 92 77\n"
                    + "89 92 63\n"
                    + "89 63 77", "0\n"
                    + "63\n"
                    + "63"
            )
        );
    }
}