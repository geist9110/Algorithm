package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_23969 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int last = N - 1; last > 0 && K > 0; last--) {
            for (int i = 0; i < last && K > 0; i++) {
                if (array[i] > array[i + 1]) {
                    K--;
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }

        if (K == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i : array) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        System.out.println(-1);
    }
}
