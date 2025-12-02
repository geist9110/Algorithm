package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import baekjoon.config.ProblemInterface;

public class Problem_33869 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String W = br.readLine();
        String S = br.readLine();

        char[] key = new char[26];
        Set<Character> used = new HashSet<>();
        int keyIndex = 0;
        for (char c : W.toCharArray()) {
            if (used.contains(c)) {
                continue;
            }

            used.add(c);
            key[keyIndex++] = c;
        }

        for (char k = 'A'; k <= 'Z'; k++) {
            if (used.contains(k)) {
                continue;
            }
            key[keyIndex++] = k;
        }

        for (char c : S.toCharArray()) {
            sb.append(key[c - 'A']);
        }
        System.out.print(sb);
    }

}
