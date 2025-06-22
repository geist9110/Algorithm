package baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2776_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2776());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "1\n"
                    + "5\n"
                    + "4 1 5 2 3\n"
                    + "5\n"
                    + "1 3 7 9 5", "1\n"
                    + "1\n"
                    + "0\n"
                    + "0\n"
                    + "1"
            )
        );
    }
}