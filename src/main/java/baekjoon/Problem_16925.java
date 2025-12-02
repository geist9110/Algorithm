package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import baekjoon.config.ProblemInterface;

public class Problem_16925 implements ProblemInterface {

    private static List<String> list;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>(N * 2 - 2);

        String first = null;
        String second = null;

        for (int i = 0; i < 2 * N - 2; i++) {
            String s = br.readLine();
            list.add(s);
            if (s.length() == N - 1) {
                if (first == null) {
                    first = s;
                } else {
                    second = s;
                }
            }
        }

        String firstCandidate = first + second.charAt(N - 2);
        String secondCandidate = second + first.charAt(N - 2);
        String S = isValidCandidate(firstCandidate) ? firstCandidate : secondCandidate;
        sb.append(S).append("\n");
        Set<String> set = new HashSet<>();
        for (String s : list) {
            if (isPrefix(S, s) && !set.contains(s)) {
                set.add(s);
                sb.append("P");
                continue;
            }
            sb.append("S");
        }

        System.out.print(sb);

    }

    private static boolean isValidCandidate(String candidate) {
        Map<String, Integer> need = new HashMap<>();
        Map<String, Integer> have = new HashMap<>();

        for (int len = 1; len < candidate.length(); len++) {
            String prefix = candidate.substring(0, len);
            String suffix = candidate.substring(candidate.length() - len);

            need.merge(prefix, 1, Integer::sum);
            need.merge(suffix, 1, Integer::sum);
        }

        for (String s : list) {
            have.merge(s, 1, Integer::sum);
        }

        return need.equals(have);
    }

    private static boolean isPrefix(String S, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (S.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
