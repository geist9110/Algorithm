package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10769_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10769());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("How are you :-) doing :-( today :-)?", "happy"),
            Arguments.of(":)", "none"),
            Arguments.of("This:-(is str:-(:-(ange te:-)xt.", "sad"),
            Arguments.of(":-(:-):-l", "unsure")
        );
    }
}