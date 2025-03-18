package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_2212 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensorLocation = new int[N];
        for (int i = 0; i < N; i++) {
            sensorLocation[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensorLocation);

        int[] distance = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = sensorLocation[i + 1] - sensorLocation[i];
        }

        Arrays.sort(distance);

        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += distance[i];
        }

        System.out.print(result);
    }

}
