package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1068 implements ProblemInterface {

    private static int[] tree;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        tree = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int remove = Integer.parseInt(br.readLine());
        tree[remove] = -2;

        int[] inputDegree = new int[N];
        for (int i = 0; i < N; i++) {
            if (tree[i] >= 0) {
                inputDegree[tree[i]]++;
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (inputDegree[i] > 0) {
                continue;
            }

            int root = find(i);
            if (root == -1) {
                result++;
            }
        }

        System.out.print(result);
    }

    private static int find(int x) {
        if (x < 0) {
            return x;
        }

        if (tree[x] == x) {
            return x;
        }

        return tree[x] = find(tree[x]);
    }
}
