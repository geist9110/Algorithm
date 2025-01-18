package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_9527_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_9527());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("2 12", "21"),
                Arguments.of("999999999999999 9999999999999999", "239502115812196386"));
    }
}
