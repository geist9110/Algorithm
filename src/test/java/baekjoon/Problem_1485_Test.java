package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_1485_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1485());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of(
                "2\n"
                    + "1 1\n1 2\n2 1\n2 2\n"
                    + "2 2\n3 3\n4 4\n5 5",
                "1\n0"
            )
        );
    }
}