package baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_2446_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2446());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5", "*********\n"
                + " *******\n"
                + "  *****\n"
                + "   ***\n"
                + "    *\n"
                + "   ***\n"
                + "  *****\n"
                + " *******\n"
                + "*********")
        );
    }
}