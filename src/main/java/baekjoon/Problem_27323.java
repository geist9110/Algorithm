package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_27323 implements ProblemInterface {

    /*
    https://www.acmicpc.net/problem/27323

    직사각형 다국어
    브론즈 5

    문제
    정수 A, B 가 주어진다. 세로 길이가 A cm, 가로 길이가 B cm 인 아래와 같은 직사각형의 넓이를 cm2 단위로 구하시오.

    입력
    표준 입력에 다음과 같은 형태로 입력이 주어진다.

    A
    B

    출력
    세로 길이가 A cm, 가로 길이가 B cm인 직사각형의 넓이를 cm2 단위로 구하고, 단위 (cm2)를 생략하여 출력한다.

    제한
    1 ≦ A ≦ 100.
    1 ≦ B ≦ 100.
    A, B 는 정수이다.
     */

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()));
    }
}
