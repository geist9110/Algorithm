package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_33869_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_33869());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("THEFIFTHSMUPC\nGOODLUCK", "MJJFBREA"),
                Arguments.of("ALGOS\nSOOKMYUNG", "RMMHJYUKC"));
    }

}
