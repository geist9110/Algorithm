package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_35030_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_35030());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of(
                        "13\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n96051\n96052\n100000",
                        "1\n2\n2\n3\n3\n4\n4\n4\n4\n4\n102\n103\n103"));
    }

}
