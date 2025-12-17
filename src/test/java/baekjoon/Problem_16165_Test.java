package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baekjoon.config.ProblemTestConfigure;

public class Problem_16165_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_16165());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("""
                        3 4
                        twice
                        9
                        jihyo
                        dahyeon
                        mina
                        momo
                        chaeyoung
                        jeongyeon
                        tzuyu
                        sana
                        nayeon
                        blackpink
                        4
                        jisu
                        lisa
                        rose
                        jenny
                        redvelvet
                        5
                        wendy
                        irene
                        seulgi
                        yeri
                        joy
                        sana
                        1
                        wendy
                        1
                        twice
                        0
                        rose
                        1""", """
                        twice
                        redvelvet
                        chaeyoung
                        dahyeon
                        jeongyeon
                        jihyo
                        mina
                        momo
                        nayeon
                        sana
                        tzuyu
                        blackpink"""));
    }

}
