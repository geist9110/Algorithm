package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_1213 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();
        int[] words = new int[26];
        for (int i = 0; i < name.length(); i++) {
            words[name.charAt(i) - 'A']++;
        }

        int oddCount = 0;
        int oddIndex = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] % 2 == 1) {
                oddCount++;
                oddIndex = i;
            }
        }

        if (
            (name.length() % 2 == 0 && oddCount != 0)
                || (name.length() % 2 == 1 && oddCount != 1)
        ) {
            bw.write("I'm Sorry Hansoo");
            bw.flush();
            return;
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i] / 2; j++) {
                bw.write(i + 'A');
            }
        }

        if (name.length() % 2 == 1) {
            bw.write(oddIndex + 'A');
        }

        for (int i = words.length - 1; i >= 0; i--) {
            for (int j = 0; j < words[i] / 2; j++) {
                bw.write(i + 'A');
            }
        }

        bw.flush();
    }
}
