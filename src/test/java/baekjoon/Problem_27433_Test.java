package baekjoon;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import baekjoon.config.ProblemTestConfigure;

public class Problem_27433_Test extends ProblemTestConfigure {

  @ParameterizedTest
  @MethodSource("testCase")
  protected void test(String input, String actual) throws IOException {
    run(input, actual, new Problem_27433());
  }

  private static Stream<Arguments> testCase() {
    return Stream.of(Arguments.of("10", "3628800"), Arguments.of("0", "1"));
  }
}
