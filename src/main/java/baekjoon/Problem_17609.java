package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_17609 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        testLoop:
        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            String s = br.readLine();

            for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
                if (s.charAt(left) == s.charAt(right)) {
                    continue;
                }

                if (
                    isSlicePalindrome(s, left + 1, right)
                        || isSlicePalindrome(s, left, right - 1)
                ) {
                    bw.write("1\n");
                    continue testLoop;
                }

                bw.write("2\n");
                continue testLoop;
            }
            bw.write("0\n");
        }

        bw.flush();
    }

    private static boolean isSlicePalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
