package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_1509 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean[][] isPalindrom = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrom[i][i] = true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrom[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        for (int window = 2; window < s.length(); window++) {
            for (int start = 0; start < s.length() - window; start++) {
                int end = start + window;
                isPalindrom[start][end] =
                        isPalindrom[start + 1][end - 1] && s.charAt(start) == s.charAt(end);

            }
        }

        int[] minPalindromSetCount = new int[s.length()];
        minPalindromSetCount[0] = 1;

        for (int end = 1; end < s.length(); end++) {
            minPalindromSetCount[end] = minPalindromSetCount[end - 1] + 1;
            for (int start = 0; start < end; start++) {
                if (!isPalindrom[start][end]) {
                    continue;
                }

                if (start == 0) {
                    minPalindromSetCount[end] = Math.min(
                            minPalindromSetCount[end],
                            1);
                    continue;
                }

                minPalindromSetCount[end] = Math.min(
                        minPalindromSetCount[end],
                        minPalindromSetCount[start - 1] + 1);
            }
        }

        System.out.print(minPalindromSetCount[s.length() - 1]);
    }

}
