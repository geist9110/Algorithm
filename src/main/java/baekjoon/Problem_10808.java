package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10808 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alphabets = new int[26];
        String S = br.readLine();
        for (int i = 0; i < S.length(); i++) {
            alphabets[S.charAt(i) - 'a']++;
        }
        for (int alphabet : alphabets) {
            sb.append(alphabet).append(" ");
        }
        System.out.print(sb);
    }
}
