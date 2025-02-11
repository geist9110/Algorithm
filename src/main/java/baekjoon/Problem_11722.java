package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_11722 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        lis[0] = A[0];

        int lisIndex = 0;
        for (int i = 1; i < N; i++) {
            if (lis[lisIndex] > A[i]) {
                lis[++lisIndex] = A[i];
                continue;
            }

            int left = 0;
            int right = lisIndex;
            while (left < right) {
                int mid = (left + right) / 2;
                if (lis[mid] > A[i]) {
                    left = mid + 1;
                    continue;
                }

                right = mid;
            }
            lis[right] = A[i];
        }

        System.out.print(lisIndex + 1);
    }

}
