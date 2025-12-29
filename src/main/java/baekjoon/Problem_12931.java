package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_12931 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int addOperation = 0;
        int shiftOperation = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                continue;
            }
            addOperation += Integer.bitCount(num);
            shiftOperation = Math.max(shiftOperation, 31 - Integer.numberOfLeadingZeros(num));
        }

        System.out.print(addOperation + shiftOperation);
    }
}
