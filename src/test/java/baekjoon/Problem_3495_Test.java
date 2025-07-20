package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_3495_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_3495(), 0.0);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "4 4\n"
                    + "/\\/\\\n"
                    + "\\../\n"
                    + ".\\.\\\n"
                    + "..\\/", "8"
            ),
            Arguments.of(
                "7 7\n"
                    + ".../\\..\n"
                    + "/\\.\\.\\.\n"
                    + "\\.\\.\\.\\\n"
                    + "/./././\n"
                    + "\\.\\/..\\\n"
                    + ".\\..../\n"
                    + "..\\/\\/.\n", "24"
            )
        );
    }
}