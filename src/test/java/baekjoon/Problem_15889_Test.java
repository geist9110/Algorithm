package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_15889_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_15889());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("5\n0 5 10 15 100\n10 5 6 100", "권병장님, 중대장님이 찾으십니다"),
                Arguments.of("5\n0 5 10 15 100\n10 5 6 0", "엄마 나 전역 늦어질 것 같아"),
                Arguments.of("1\n0", "권병장님, 중대장님이 찾으십니다"));
    }

}
