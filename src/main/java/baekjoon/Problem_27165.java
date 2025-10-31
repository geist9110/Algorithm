package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_27165 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> oneList = new LinkedList<>();
        int[] array = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            if (array[i] == 1) {
                oneList.add(i);
            }
        }

        if (oneList.size() > 2) {
            System.out.print("NO");
            return;
        }

        if (oneList.size() == 0) {
            int zeroCount = 0;
            for (int i = 1; i <= n; i++) {
                if (array[i] == 0) {
                    zeroCount++;
                }
            }

            if (zeroCount == n) {
                System.out.print("NO");
                return;
            }

            for (int i = 0; i + x <= n; i++) {
                if (array[i] - 1 >= 2 && array[i + x] + 1 >= 2) {
                    System.out.printf("YES\n%d %d", i, i + x);
                    return;
                }
            }

            System.out.print("NO");
            return;
        }

        if (oneList.size() == 1) {
            int one = oneList.get(0);
            if (one + x <= n && array[one + x] + 1 >= 2) {
                System.out.printf("YES\n%d %d", one, one + x);
                return;
            }
            if (one - x >= 0 && array[one - x] - 1 >= 2) {
                System.out.printf("YES\n%d %d", one - x, one);
                return;
            }
            System.out.print("NO");
            return;
        }

        if (oneList.size() != 2) {
            System.out.print("NO");
            return;
        }

        if (Math.abs(oneList.get(0) - oneList.get(1)) != x) {
            System.out.print("NO");
            return;
        }

        System.out.printf("YES\n%d %d", oneList.get(0), oneList.get(1));
    }
}
