package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_6527_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_6527());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "Programming languages can be classified BULLSHIT into following types:\n"
                    + "- imperative and BULLSHIT procedural languages\n"
                    + "- functional languages\n"
                    + "- logical BULLSHIT programming languages\n"
                    + "- object-oriented BULLSHIT languages", "9 / 2"
            )
        );
    }
}