package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_24883 implements ProblemInterface {

  public void solution(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();

    if (s.charAt(0) == 'N' || s.charAt(0) == 'n') {
      System.out.print("Naver D2");
      return;
    }

    System.out.print("Naver Whale");
  }
}
