package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_5052_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5052());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "2\n"
                    + "3\n911\n97625999\n91125426\n"
                    + "5\n113\n12340\n123440\n12345\n98346", "NO\nYES"
            ),
            Arguments.of(
                "2\n"
                    + "1\n"
                    + "1\n"
                    + "2\n"
                    + "11111\n"
                    + "20", "YES\n"
                    + "YES"
            ),
            Arguments.of(
                "1\n"
                    + "3\n"
                    + "2\n"
                    + "02\n"
                    + "0", "NO"
            )
        );
    }
}