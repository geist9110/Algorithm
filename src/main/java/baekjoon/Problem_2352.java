package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2352 implements ProblemInterface {

  public void solution(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] lis = new int[N];
    lis[0] = arr[0];
    int length = 1;
    for (int i = 1; i < N; i++) {
      int left = 0;
      int right = length;
      while (left < right) {
        int mid = (left + right) / 2;
        if (lis[mid] < arr[i]) {
          left = mid + 1;
          continue;
        }
        right = mid;
      }
      lis[left] = arr[i];
      if (left == length) {
        length++;
      }
    }

    System.out.print(length);
  }
}
