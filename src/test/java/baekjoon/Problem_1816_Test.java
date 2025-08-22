package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1816_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1816());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "3\n"
                    + "1000036000099\n"
                    + "1500035500153\n"
                    + "20000000000002", "YES\n"
                    + "NO\n"
                    + "NO"
            )
        );
    }
}