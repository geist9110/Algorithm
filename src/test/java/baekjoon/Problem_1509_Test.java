package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_1509_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_1509());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("QWERTYTREWQWERT", "5"),
                Arguments.of("BBCDDECAECBDABADDCEBACCCBDCAABDBADD", "22"),
                Arguments.of("AAAA", "1"),
                Arguments.of("ABCDEFGH", "8"));
    }

}
