package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_3020 implements ProblemInterface {

  public void solution(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int[] top = new int[H + 2];
    int[] bottom = new int[H + 2];

    for (int i = 1; i <= N; i++) {
      int height = Integer.parseInt(br.readLine());
      if (i % 2 == 0) {
        top[H - height + 1]++;
        continue;
      }
      bottom[height]++;
    }

    for (int i = H; i >= 1; i--) {
      top[i] += top[i + 1];
    }

    for (int i = 1; i <= H; i++) {
      bottom[i] += bottom[i - 1];
    }

    int min = Integer.MAX_VALUE;
    int count = 0;
    for (int height = 1; height <= H; height++) {
      int result = N - top[height + 1] - bottom[height - 1];
      if (result < min) {
        min = result;
        count = 1;
      } else if (result == min) {
        count++;
      }
    }

    System.out.print(min + " " + count);
  }
}
