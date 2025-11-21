package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_15889 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] people = new int[N];
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int maxReach = 0;
        if (N > 1) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < N - 1; i++) {
            int currentReach = Integer.parseInt(st.nextToken());
            maxReach = Math.max(maxReach, currentReach + people[i]);
            if (maxReach < people[i + 1]) {
                System.out.print("엄마 나 전역 늦어질 것 같아");
                return;
            }
        }
        System.out.print("권병장님, 중대장님이 찾으십니다");
    }

}
