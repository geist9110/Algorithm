package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem_17219_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_17219());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
            Arguments.of("16 4\n"
                + "noj.am IU\n"
                + "acmicpc.net UAENA\n"
                + "startlink.io THEKINGOD\n"
                + "google.com ZEZE\n"
                + "nate.com VOICEMAIL\n"
                + "naver.com REDQUEEN\n"
                + "daum.net MODERNTIMES\n"
                + "utube.com BLACKOUT\n"
                + "zum.com LASTFANTASY\n"
                + "dreamwiz.com RAINDROP\n"
                + "hanyang.ac.kr SOMEDAY\n"
                + "dhlottery.co.kr BOO\n"
                + "duksoo.hs.kr HAVANA\n"
                + "hanyang-u.ms.kr OBLIVIATE\n"
                + "yd.es.kr LOVEATTACK\n"
                + "mcc.hanyang.ac.kr ADREAMER\n"
                + "startlink.io\n"
                + "acmicpc.net\n"
                + "noj.am\n"
                + "mcc.hanyang.ac.kr", "THEKINGOD\n"
                + "UAENA\n"
                + "IU\n"
                + "ADREAMER\n")
        );
    }
}