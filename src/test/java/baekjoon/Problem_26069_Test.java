package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_26069_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_26069());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("12\n"
                + "bnb2011 chansol\n"
                + "chansol chogahui05\n"
                + "chogahui05 jthis\n"
                + "jthis ChongChong\n"
                + "jthis jyheo98\n"
                + "jyheo98 lms0806\n"
                + "lms0806 pichulia\n"
                + "pichulia pjshwa\n"
                + "pjshwa r4pidstart\n"
                + "r4pidstart swoon\n"
                + "swoon tony9402\n"
                + "tony9402 bnb2011", "10")
        );
    }
}