package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2623_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2623());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("6 3\n3 1 4 3\n4 6 2 5 4\n2 2 3", "1\n6\n2\n5\n4\n3"),
                Arguments.of("2 2\n2 1 2\n2 2 1", "0"), Arguments.of("5 7\n" + //
                        "5 1 2 3 4 5\n" + //
                        "5 1 2 3 4 5\n" + //
                        "5 1 2 3 4 5\n" + //
                        "5 1 2 3 4 5\n" + //
                        "5 1 2 3 4 5\n" + //
                        "5 1 2 3 4 5\n" + //
                        "5 1 2 3 4 5", "1\n2\n3\n4\n5"));
    }

}
