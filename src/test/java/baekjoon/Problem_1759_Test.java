package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1759_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1759());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "4 6\na t c i s w",
                        "acis\nacit\naciw\nacst\nacsw\nactw\naist\naisw\naitw\nastw\ncist\ncisw\ncitw\nistw"),
                Arguments.of("3 3\na g m", "agm")

        );
    }
}
