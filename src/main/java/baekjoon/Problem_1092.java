package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1092 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> crane = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        crane.sort(Comparator.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> box = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        box.sort(Comparator.reverseOrder());

        if (crane.get(0) < box.get(0)) {
            System.out.print(-1);
            return;
        }

        int result = 0;
        while (!box.isEmpty()) {
            result++;

            for (int craneIndex = 0, boxIndex = 0; craneIndex < N && boxIndex < box.size();) {
                if (box.get(boxIndex) <= crane.get(craneIndex)) {
                    box.remove(boxIndex);
                    craneIndex++;
                    continue;
                }
                boxIndex++;
            }
        }

        System.out.print(result);
    }

}
