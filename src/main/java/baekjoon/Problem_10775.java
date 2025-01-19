package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_10775 implements ProblemInterface {

    private static int[] unionFind;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        unionFind = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            unionFind[i] = i;
        }

        int[] airPlains = new int[P];
        for (int i = 0; i < P; i++) {
            airPlains[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int airPlain : airPlains) {
            int nextGate = find(airPlain);

            if (nextGate == 0) {
                break;
            }

            result++;
            unionFind[find(airPlain)] = find(nextGate - 1);
        }

        System.out.println(result);
    }

    private static int find(int x) {
        if (unionFind[x] == x) {
            return x;
        }
        return unionFind[x] = find(unionFind[x]);
    }

}
