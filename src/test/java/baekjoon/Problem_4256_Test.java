package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_4256_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_4256());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "2\n"
                    + "4\n"
                    + "3 2 1 4\n"
                    + "2 3 4 1\n"
                    + "8\n"
                    + "3 6 5 4 8 7 1 2\n"
                    + "5 6 8 4 3 1 2 7", "2 4 1 3\n"
                    + "5 8 4 6 2 1 7 3"
            )
        );
    }
}