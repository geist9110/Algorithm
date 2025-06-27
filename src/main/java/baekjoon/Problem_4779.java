package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import baekjoon.config.ProblemInterface;

public class Problem_4779 implements ProblemInterface {

  public void solution(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input;
    while ((input = br.readLine()) != null) {
      int N = Integer.parseInt(input);
      int length = (int) Math.pow(3, N);
      char[] line = new char[length];
      for (int i = 0; i < length; i++) {
        line[i] = '-';
      }

      cantorSet(line, 0, length - 1);
      for (int i = 0; i < length; i++) {
        bw.write(line[i]);
      }
      bw.newLine();
    }

    bw.flush();
  }

  private static void cantorSet(char[] line, int start, int end) {
    if (start == end) {
      return;
    }
    int length = (end - start + 1) / 3;
    for (int i = start + length; i <= end - length; i++) {
      line[i] = ' ';
    }
    cantorSet(line, start, start + length - 1);
    cantorSet(line, end - length + 1, end);
  }
}
