package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10610_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10610());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("30", "30"),
            Arguments.of("102", "210"),
            Arguments.of("2931", "-1"),
            Arguments.of("80875542", "88755420")
        );
    }
}