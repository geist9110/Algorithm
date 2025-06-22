package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_7795_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_7795());
    }

    public static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "2\n"
                    + "5 3\n"
                    + "8 1 7 3 1\n"
                    + "3 6 1\n"
                    + "3 4\n"
                    + "2 13 7\n"
                    + "103 11 290 215", "7\n"
                    + "1"
            )
        );
    }
}