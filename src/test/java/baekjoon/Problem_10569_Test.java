package baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_10569_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10569());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("2\n"
                + "8 12\n"
                + "4 6", "6\n"
                + "4")
        );
    }
}