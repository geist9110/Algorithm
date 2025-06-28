package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2075_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2075());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("5\n" + "12 7 9 15 5\n" + "13 8 11 19 6\n"
                + "21 10 26 31 16\n" + "48 14 28 35 25\n" + "52 20 32 41 49", "35"));
    }

}
