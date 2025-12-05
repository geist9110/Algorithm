package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_2371 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Long>> lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Long> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            long file = Long.parseLong(st.nextToken());
            while (file != -1) {
                list.add(file);
                file = Long.parseLong(st.nextToken());
            }
            lists.add(list);
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                result = Math.max(result, getMinK(lists.get(i), lists.get(j), 0));
            }
        }
        System.out.print(result);
    }

    private static long getMinK(List<Long> a, List<Long> b, int depth) {
        long aNumber = a.size() > depth ? a.get(depth) : 0;
        long bNumber = b.size() > depth ? b.get(depth) : 0;

        if (aNumber != bNumber) {
            return depth + 1;
        }

        return getMinK(a, b, depth + 1);
    }

}
