package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_25757 implements ProblemInterface {

    private static final String YUTNORI = "Y";
    private static final String FIND_THE_SAME_PICTURE = "F";
    private static final String ONE_CARD = "O";

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> user = new HashSet<>();
        for (int i = 0; i < N; i++) {
            user.add(br.readLine());
        }

        if (game.equals(YUTNORI)) {
            System.out.print(user.size());
            return;
        }

        if (game.equals(FIND_THE_SAME_PICTURE)) {
            System.out.print(user.size() / 2);
            return;
        }

        if (game.equals(ONE_CARD)) {
            System.out.print(user.size() / 3);
        }
    }
}
