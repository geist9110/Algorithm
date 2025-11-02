package baekjoon;

import baekjoon.config.ProblemTestConfigure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class Problem_27497_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_27497());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n1 a\n2 b\n1 c\n3\n3", "a"),
                Arguments.of("9\n1 c\n2 n\n1 h\n1 o\n2 i\n1 R\n3\n2 S\n1 n", "Sinchon"),
                Arguments.of("7\n2 Y\n3\n1 R\n3\n3\n2 n\n2 O", "On"),
                Arguments.of("11\n1 u\n3\n2 z\n3\n1 s\n2 A\n3\n1 a\n3\n3\n3", "0"),
                Arguments.of("5\n1 a\n1 b\n3\n2 b\n3", "a"));
    }
}
