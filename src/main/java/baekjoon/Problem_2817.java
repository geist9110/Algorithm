package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import baekjoon.config.ProblemInterface;

public class Problem_2817 implements ProblemInterface {

    private static class Staff {
        String name;
        long value;

        public Staff(String name, long value) {
            this.name = name;
            this.value = value;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long X = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long minVote = X / 20;

        List<Staff> alpsSet = new ArrayList<>();
        SortedMap<String, Integer> deservedStaff = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            long voted = Long.parseLong(st.nextToken());
            if (voted < minVote) {
                continue;
            }
            deservedStaff.put(name, 0);

            for (int j = 1; j <= 14; j++) {
                alpsSet.add(new Staff(name, voted / j));
            }
        }
        alpsSet.sort((o1, o2) -> Long.compare(o2.value, o1.value));

        for (int i = 0; i < 14; i++) {
            deservedStaff.merge(alpsSet.get(i).name, 1, Integer::sum);
        }

        StringBuilder sb = new StringBuilder();
        deservedStaff.forEach((name, value) -> {
            sb.append(name).append(" ").append(value).append("\n");
        });

        System.out.print(sb);
    }

}
