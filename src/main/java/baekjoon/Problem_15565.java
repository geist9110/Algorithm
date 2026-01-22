package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_15565 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>(N);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                list.add(i);
            }
        }

        if (list.size() < K) {
            System.out.print(-1);
            return;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i + K - 1 < list.size(); i++) {
            int size = list.get(i + K - 1) - list.get(i) + 1;
            result = Math.min(result, size);
        }

        System.out.print(result);
    }

}
