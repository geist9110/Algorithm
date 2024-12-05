package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5525 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.readLine();
        String s = br.readLine();

        int result = 0;
        int count = 0;

        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                count++;
                i++;
                if (count == N) {
                    result++;
                    count--;
                }
                continue;
            }
            count = 0;
        }

        System.out.println(result);
    }
}
