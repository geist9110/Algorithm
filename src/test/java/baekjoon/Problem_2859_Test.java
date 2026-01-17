package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_2859_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2859());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("02:20\n13:00\n05:50\n01:00", "Saturday\n14:00"),
                Arguments.of("02:20\n23:28\n00:40\n23:50", "Never"),
                Arguments.of("23:19\n10:19\n02:42\n09:11", "Thursday\n00:31"),
                Arguments.of("00:00\n23:59\n00:01\n23:59", "Saturday\n23:59"));
    }

}
