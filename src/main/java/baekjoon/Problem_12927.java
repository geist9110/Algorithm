package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_12927 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();
        int count = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'N') {
                continue;
            }

            count++;
            for (int j = i + 1; j <= s.length; j += (i + 1)) {
                s[j - 1] = s[j - 1] == 'Y' ? 'N' : 'Y';
            }
        }

        System.out.print(count);
    }
}
