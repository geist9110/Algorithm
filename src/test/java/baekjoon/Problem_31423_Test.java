package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_31423_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_31423());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("""
                        5
                        sogang
                        sookmyung
                        yonsei
                        ewha
                        hongik
                        2 3
                        1 2
                        4 5
                        1 4""", "sogangsookmyungyonseiewhahongik"));
    }

}
