package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_4659_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_4659());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("a\n"
                + "tv\n"
                + "ptoui\n"
                + "bontres\n"
                + "zoggax\n"
                + "wiinq\n"
                + "eep\n"
                + "houctuh\n"
                + "end", "<a> is acceptable.\n"
                + "<tv> is not acceptable.\n"
                + "<ptoui> is not acceptable.\n"
                + "<bontres> is not acceptable.\n"
                + "<zoggax> is not acceptable.\n"
                + "<wiinq> is not acceptable.\n"
                + "<eep> is acceptable.\n"
                + "<houctuh> is acceptable."),
            Arguments.of("aaroo\n"
                + "end", "<aaroo> is not acceptable.")
        );
    }
}