package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_5073 implements ProblemInterface {

    /*
    https://www.acmicpc.net/problem/5073

    삼각형과 세 변 다국어
    브론즈 3

    문제
    삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.

    Equilateral :  세 변의 길이가 모두 같은 경우
    Isosceles : 두 변의 길이만 같은 경우
    Scalene : 세 변의 길이가 모두 다른 경우
    단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.

    세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.

    입력
    각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.

    출력
    각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.
     */

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (isStop(a, b, c)) {
                break;
            }

            if (isInvalid(a, b, c)) {
                sb.append("Invalid\n");
                continue;
            }
            if (isEquilateral(a, b, c)) {
                sb.append("Equilateral\n");
                continue;
            }
            if (isIsosceles(a, b, c)) {
                sb.append("Isosceles\n");
                continue;
            }
            sb.append("Scalene\n");
        }
        System.out.print(sb.toString().trim());
    }

    private static boolean isStop(int a, int b, int c) {
        return a == 0 && b == 0 && c == 0;
    }

    private static boolean isInvalid(int a, int b, int c) {
        return a + b <= c || a + c <= b || b + c <= a;
    }

    private static boolean isEquilateral(int a, int b, int c) {
        return a == b && b == c;
    }

    private static boolean isIsosceles(int a, int b, int c) {
        return a == b || b == c || a == c;
    }
}
