package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_25114 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        StringTokenizer aStringTokenizer = new StringTokenizer(br.readLine());
        StringTokenizer bStringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(aStringTokenizer.nextToken());
            b[i] = Integer.parseInt(bStringTokenizer.nextToken());
        }

        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            if (a[i] == b[i]) {
                continue;
            }
            int x = a[i] ^ b[i];
            a[i + 1] ^= x;
            count++;
        }

        if (a[N - 1] == b[N - 1]) {
            System.out.print(count);
            return;
        }
        System.out.print(-1);
    }

}
