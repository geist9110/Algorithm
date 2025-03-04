package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_2631 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] lis = new int[N];
        int lisIndex = 0;
        lis[lisIndex] = Integer.parseInt(br.readLine());

        for (int childIndex = 1; childIndex < N; childIndex++) {
            int child = Integer.parseInt(br.readLine());

            if (lis[lisIndex] < child) {
                lis[++lisIndex] = child;
                continue;
            }

            int left = 0;
            int right = lisIndex;

            while (left < right) {
                int mid = (left + right) / 2;
                if (lis[mid] > child) {
                    right = mid;
                    continue;
                }
                if (lis[mid] < child) {
                    left = mid + 1;
                }
            }

            lis[right] = child;
        }
        System.out.print(N - lisIndex - 1);
    }
}
