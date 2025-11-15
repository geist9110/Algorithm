package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_28126_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_28126());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\nUUXRX\n5\n1 3\n2 4\n3 2\n4 3\n4 5", "5"),
                Arguments.of("5\nUUXRX\n5\n1 4\n2 5\n3 1\n4 2\n5 3", "0"));
    }

}
