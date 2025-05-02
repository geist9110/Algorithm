package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1302_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1302());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("5\ntop\ntop\ntop\ntop\nkimtop", "top"),
            Arguments.of(
                "9\ntable\nchair\ntable\ntable\nlamp\ndoor\nlamp\ntable\nchair",
                "table"
            ),
            Arguments.of("6\na\na\na\nb\nb\nb", "a"),
            Arguments.of(
                "8\nicecream\npeanuts\npeanuts\nchocolate\ncandy\nchocolate\nicecream\napple",
                "chocolate"
            ),
            Arguments.of("1\nsoul", "soul")
        );
    }
}