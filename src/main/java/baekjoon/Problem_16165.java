package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_16165 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> memberTeamMap = new HashMap<>();
        Map<String, List<String>> teamMemberMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String team = br.readLine();
            List<String> members = new LinkedList<>();
            int memberCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < memberCount; j++) {
                String member = br.readLine();
                members.add(member);
                memberTeamMap.put(member, team);
            }

            Collections.sort(members);
            teamMemberMap.put(team, members);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            String command = br.readLine();

            if (command.equals("1")) {
                sb.append(memberTeamMap.get(input)).append("\n");
                continue;
            }

            for (String member : teamMemberMap.get(input)) {
                sb.append(member).append("\n");
            }
        }

        System.out.print(sb);
    }

}
