package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_11568 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        lis[0] = array[0];
        int index = 0;

        for (int i = 1; i < N; i++) {
            if (lis[index] < array[i]) {
                lis[++index] = array[i];
                continue;
            }

            int left = 0;
            int right = index;
            while (left < right) {
                int mid = (left + right) / 2;
                if (lis[mid] < array[i]) {
                    left = mid + 1;
                    continue;
                }
                right = mid;
            }

            lis[left] = array[i];
        }

        System.out.print(index + 1);
    }

}
