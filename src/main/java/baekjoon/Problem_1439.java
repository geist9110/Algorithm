package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_1439 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        char prevChar = '-';
        int zeroCount = 0;
        int oneCount = 0;

        for (char nextChar : S.toCharArray()) {
            if (prevChar == nextChar) {
                continue;
            }

            if (nextChar == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }

            prevChar = nextChar;
        }

        System.out.print(Math.min(zeroCount, oneCount));
    }

}
