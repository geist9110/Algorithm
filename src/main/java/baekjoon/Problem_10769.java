package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10769 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int happyEmoticonCount = 0;
        int sadEmoticonCount = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == ':' && str.charAt(i + 1) == '-') {
                if (str.charAt(i + 2) == ')') {
                    happyEmoticonCount++;
                }
                if (str.charAt(i + 2) == '(') {
                    sadEmoticonCount++;
                }
            }
        }

        if (happyEmoticonCount == 0 && sadEmoticonCount == 0) {
            System.out.print("none");
            return;
        }
        if (happyEmoticonCount == sadEmoticonCount) {
            System.out.print("unsure");
            return;
        }
        if (happyEmoticonCount > sadEmoticonCount) {
            System.out.print("happy");
            return;
        }
        if (sadEmoticonCount > happyEmoticonCount) {
            System.out.print("sad");
        }
    }
}
