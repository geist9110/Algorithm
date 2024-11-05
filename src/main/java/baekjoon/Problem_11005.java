package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_11005 implements ProblemInterface {
    /*
    https://www.acmicpc.net/problem/11005

    진법 변환 2
    브론즈 1

    문제
    10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.

    10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다.
    이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

    A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

    입력
    첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.

    출력
    첫째 줄에 10진법 수 N을 B진법으로 출력한다.
     */

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        while (s > 0) {
            stack.push(s % N);
            s = s / N;
        }

        while (!stack.isEmpty()) {
            sb.append(intToChar(stack.pop()));
        }

        System.out.print(sb);
    }

    private static char intToChar(long i) {
        if (i <= 9) {
            return (char) (i + '0');
        }
        return (char) (i + 55);
    }
}
