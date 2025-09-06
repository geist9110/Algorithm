package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_31799_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_31799());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "12\n"
                    + "A+BC+C0C-B0B-B+A0AC+C-", "EBBBBDBPEPBB"
            ),
            Arguments.of(
                "3\n"
                    + "ABC", "EBB"
            ),
            Arguments.of(
                "4\n"
                    + "A+A0AA-", "EPPD"
            )
        );
    }
}