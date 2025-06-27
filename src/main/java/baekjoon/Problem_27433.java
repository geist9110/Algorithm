package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_27433 implements ProblemInterface {

  public void solution(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(br.readLine());
    System.out.print(factorial(N));
  }

  private static long factorial(long n) {
    if (n == 0) {
      return 1;
    }
    return n * factorial(n - 1);
  }
}
