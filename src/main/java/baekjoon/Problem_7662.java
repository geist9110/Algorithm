package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem_7662 implements ProblemInterface {

    private static final char INSERT = 'I';
    private static final char DELETE = 'D';
    private static final byte DELETE_MAXIMUM = 1;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char instruction = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());

                if (instruction == INSERT) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                    continue;
                }
                if (instruction == DELETE) {
                    if (map.isEmpty()) {
                        continue;
                    }

                    int number = value == DELETE_MAXIMUM ? map.lastKey() : map.firstKey();
                    map.put(number, map.get(number) - 1);

                    if (map.get(number) == 0) {
                        map.remove(number);
                    }
                }
            }

            bw.write(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey());
            bw.newLine();
        }

        bw.flush();
    }
}
