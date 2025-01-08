package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_10942_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_10942());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("7\n" + //
                "1 2 1 3 1 2 1\n" + //
                "4\n" + //
                "1 3\n" + //
                "2 5\n" + //
                "3 3\n" + //
                "5 7", "1\n" + //
                        "0\n" + //
                        "1\n" + //
                        "1"));
    }

}
