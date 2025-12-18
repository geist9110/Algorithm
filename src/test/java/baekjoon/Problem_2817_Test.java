package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2817_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2817());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("235217\n3\nA 107382\nC 18059\nB 43265", "A 9\nB 4\nC 1"),
                Arguments.of("245143\n4\nF 14845\nA 104516\nB 52652\nC 14161", "A 8\nB 4\nC 1\nF 1"),
                Arguments.of("206278\n5\nD 44687\nA 68188\nC 7008\nB 48377\nG 9665", "A 6\nB 4\nD 4"));
    }

}
