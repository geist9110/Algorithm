package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_25326_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_25326());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "5 4\n"
                    + "kor apple red\n"
                    + "kor pear blue\n"
                    + "eng apple red\n"
                    + "eng orange blue\n"
                    + "math apple green\n"
                    + "kor apple red\n"
                    + "kor - blue\n"
                    + "eng - -\n"
                    + "- - red",
                "1\n"
                    + "1\n"
                    + "2\n"
                    + "2"
            )
        );
    }
}