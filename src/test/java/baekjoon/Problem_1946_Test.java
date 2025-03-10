package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1946_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1946());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "2\n5\n3 2\n1 4\n4 1\n2 3\n5 5\n7\n3 6\n7 3\n4 2\n1 4\n5 7\n2 5\n6 1",
                        "4\n3"));
    }
}
