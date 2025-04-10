package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_25629 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int odd = 0;
        int even = 0;

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number % 2 == 0) {
                even++;
                continue;
            }
            odd++;
        }

        if ((N % 2 == 0 && odd == even) || (N % 2 == 1 && even == odd - 1)) {
            System.out.print(1);
            return;
        }

        System.out.print(0);
    }
}
