package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_2444 implements ProblemInterface {

    /*
    https://www.acmicpc.net/problem/2444

    별 찍기 - 7
    브론즈 3

    문제
    예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

    입력
    첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

    출력
    첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
     */
    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int totalIteration = 2 * N - 1;

        for (int i = 1; i <= totalIteration; i++) {
            sb.append(" ".repeat(calcSpacePerLine(N, i)))
                .append("*".repeat(calcStarPerLine(N, totalIteration, i)))
                .append("\n");
        }
        String result = sb.toString();
        bw.write(result.substring(0, result.length() - 1));
        bw.close();
    }

    private int calcSpacePerLine(int N, int i) {
        return Math.abs(N - i);
    }

    private int calcStarPerLine(int N, int totalIteration, int i) {
        return 2 * (Math.abs(Math.abs(N - i) - totalIteration) - (totalIteration - N)) - 1;
    }
}
