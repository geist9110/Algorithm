package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_30009 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int minX = X - R;
        int maxX = X + R;

        int A = 0;
        int B = 0;
        for (int i = 0; i < N; i++) {
            int line = Integer.parseInt(br.readLine());

            if (minX < line && line < maxX) {
                A++;
                continue;
            }

            if (minX == line || maxX == line) {
                B++;
                continue;
            }
        }

        System.out.printf("%d %d", A, B);
    }

}
