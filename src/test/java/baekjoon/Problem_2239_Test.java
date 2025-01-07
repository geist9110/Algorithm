package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_2239_Test extends ProblemTestConfigure {

    @ParameterizedTest
    @MethodSource("testCase")
    protected void test(String input, String actual) throws IOException {
        run(input, actual, new Problem_2239());
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(Arguments.of("103000509\n" + //
                "002109400\n" + //
                "000704000\n" + //
                "300502006\n" + //
                "060000050\n" + //
                "700803004\n" + //
                "000401000\n" + //
                "009205800\n" + //
                "804000107", "143628579\n" + //
                        "572139468\n" + //
                        "986754231\n" + //
                        "391542786\n" + //
                        "468917352\n" + //
                        "725863914\n" + //
                        "237481695\n" + //
                        "619275843\n" + //
                        "854396127"));
    }

}
