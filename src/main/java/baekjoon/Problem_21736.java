package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_21736 implements ProblemInterface {

    private static final char WALL = 'X';
    private static final char PERSON = 'P';
    private static final char DOYEON = 'I';

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        int currentX = 0, currentY = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == DOYEON) {
                    currentX = i;
                    currentY = j;
                }
            }
        }

        int meetPeopleCount = move(currentX, currentY, map);
        if (meetPeopleCount == 0) {
            System.out.print("TT");
            return;
        }
        System.out.print(meetPeopleCount);
    }

    private static int move(int currentX, int currentY, char[][] map) {
        int meetPeopleCount = 0;

        if (map[currentX][currentY] == WALL) {
            return meetPeopleCount;
        }

        if (map[currentX][currentY] == PERSON) {
            meetPeopleCount++;
        }

        map[currentX][currentY] = WALL;

        if (currentX - 1 >= 0) {
            meetPeopleCount += move(currentX - 1, currentY, map);
        }
        if (currentX + 1 < map.length) {
            meetPeopleCount += move(currentX + 1, currentY, map);
        }
        if (currentY - 1 >= 0) {
            meetPeopleCount += move(currentX, currentY - 1, map);
        }
        if (currentY + 1 < map[0].length) {
            meetPeopleCount += move(currentX, currentY + 1, map);
        }

        return meetPeopleCount;
    }
}
