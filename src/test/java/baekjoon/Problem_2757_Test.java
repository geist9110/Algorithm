package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2757_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2757());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "R1C1\nR3C1\nR1C3\nR299999999C26\nR52C52\nR53C17576\nR53C17602\nR0C0",
                        "A1\nA3\nC1\nZ299999999\nAZ52\nYYZ53\nYZZ53"));
    }

}
