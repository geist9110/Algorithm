package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_14891 implements ProblemInterface {

    private static final char N = '0';
    private static final char S = '1';
    private static final int CLOCKWISE = 1;
    private static final int COUNTER_CLOCKWISE = 2;

    private static class Gear {

        ArrayList<Character> sawTooth = new ArrayList<>();

        public Gear(String sawTooth) {
            for (char c : sawTooth.toCharArray()) {
                this.sawTooth.add(c);
            }
        }

        public Character getRightSawTooth() {
            return this.sawTooth.get(2);
        }

        public Character getLeftSawTooth() {
            return this.sawTooth.get(6);
        }

        public Character getTopSawTooth() {
            return this.sawTooth.get(0);
        }

        public void turnClockwise() {
            char lastSawTooth = this.sawTooth.remove(this.sawTooth.size() - 1);
            this.sawTooth.add(0, lastSawTooth);
        }

        public void turnCounterClockwise() {
            char firstSawTooth = this.sawTooth.remove(0);
            this.sawTooth.add(this.sawTooth.size(), firstSawTooth);
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Gear[] gears = new Gear[4];
        for (int i = 0; i < 4; i++) {
            gears[i] = new Gear(br.readLine());
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int[] isRotated = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rotateGearIndex = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            if (direction == -1) {
                direction = COUNTER_CLOCKWISE;
            }

            isRotated[rotateGearIndex] = direction;
            for (int j = rotateGearIndex; j < 4; j++) {
                if (j + 1 == 4 || gears[j].getRightSawTooth() == gears[j + 1].getLeftSawTooth()) {
                    break;
                }
                isRotated[j + 1] = (isRotated[j] % 2) + 1;
            }

            for (int j = rotateGearIndex; j >= 0; j--) {
                if (j - 1 < 0 || gears[j].getLeftSawTooth() == gears[j - 1].getRightSawTooth()) {
                    break;
                }

                isRotated[j - 1] = (isRotated[j] % 2) + 1;
            }

            for (int j = 0; j < 4; j++) {
                if (isRotated[j] == CLOCKWISE) {
                    gears[j].turnClockwise();
                    continue;
                }

                if (isRotated[j] == COUNTER_CLOCKWISE) {
                    gears[j].turnCounterClockwise();
                }
            }
        }

        int result = 0;
        int weight = 1;
        for (Gear gear : gears) {
            if (gear.getTopSawTooth() == S) {
                result += weight;
            }
            weight *= 2;
        }

        System.out.print(result);
    }
}
