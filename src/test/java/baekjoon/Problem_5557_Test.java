package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_5557_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_5557());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("11\n8 3 2 4 8 7 2 4 0 8 8", "10"),
                Arguments.of(
                        "40\n1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1",
                        "7069052760"),
                Arguments.of("3\n1 1 0", "1"),
                Arguments.of("3\n0 0 0", "2"),
                Arguments.of("20\n5 2 7 1 5 8 1 4 2 8 9 4 7 2 1 6 5 7 1 3", "488"),
                Arguments.of(
                        "40\n3 5 1 8 7 8 4 3 6 6 2 7 5 4 9 4 4 6 5 9 4 0 5 9 9 7 3 3 5 1 1 4 2 0 8 0 3 8 3 3",
                        "3443144"),
                Arguments.of("50\n" + //
                        "5 4 7 4 5 2 5 8 2 9 1 2 9 3 7 2 3 0 3 0 1 5 3 2 4 4 7 1 8 4 5 8 0 7 5 6 8 7 5 7 8 0 7 4 2 9 6 3 4 9",
                        "1671496112"),
                Arguments.of("90\n" + //
                        "6 9 7 8 9 0 2 3 6 8 6 4 1 3 1 7 7 2 2 4 4 7 5 5 4 8 6 4 1 7 0 8 3 8 6 7 3 7 7 1 8 7 1 4 2 1 6 8 6 8 7 9 0 2 6 0 9 1 6 6 4 4 5 6 6 3 3 6 1 3 8 1 8 0 4 6 6 4 7 0 1 5 2 7 4 8 7 8 6 4",
                        "31320243434344576"),
                Arguments.of("100\n" + //
                        "0 7 2 8 4 8 3 9 4 9 7 9 0 8 4 7 9 0 1 5 3 4 3 6 9 1 9 3 0 4 7 1 3 8 6 1 8 2 4 4 3 1 3 2 7 9 6 7 6 0 0 7 0 8 8 2 8 6 4 2 7 1 6 7 0 1 6 9 6 7 9 9 3 9 4 6 3 4 1 5 5 1 3 2 6 7 1 9 4 3 8 0 4 8 7 4 7 8 1 6",
                        "671013170798012928")

        );
    }
}
