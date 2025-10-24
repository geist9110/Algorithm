package baekjoon;

import baekjoon.config.ProblemTestConfigure;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Problem_24883_Test extends ProblemTestConfigure {

  @ParameterizedTest
  @MethodSource("testCase")
  protected void test(String input, String actual) throws IOException {
    run(input, actual, new Problem_24883());
  }

  private static Stream<Arguments> testCase() {
    return Stream.of(
        Arguments.of("N", "Naver D2"),
        Arguments.of("n", "Naver D2"),
        Arguments.of("A", "Naver Whale"),
        Arguments.of("g", "Naver Whale"));
  }
}
