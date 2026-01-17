package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_2859 implements ProblemInterface {

    private static final long ONE_DAY_MINUTES = 24 * 60;

    private static final String NEVER = "Never";
    private static final String[] DAYS = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday" };

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long firstStarBlinkTime = toMinutes(br.readLine());
        long secondStarBlinkTime = toMinutes(br.readLine());
        long firstStarBlinkCycle = toMinutes(br.readLine());
        long secondStarBlinkCycle = toMinutes(br.readLine());

        while (firstStarBlinkTime != secondStarBlinkTime && firstStarBlinkTime < Integer.MAX_VALUE) {
            if (firstStarBlinkTime < secondStarBlinkTime) {
                firstStarBlinkTime += firstStarBlinkCycle;
            } else {
                secondStarBlinkTime += secondStarBlinkCycle;
            }
        }

        if (firstStarBlinkTime >= Integer.MAX_VALUE) {
            System.out.print(NEVER);
            return;
        }

        int dayIndex = (int) (firstStarBlinkTime / ONE_DAY_MINUTES) % 7;
        long timeInDay = firstStarBlinkTime % ONE_DAY_MINUTES;
        long hours = timeInDay / 60;
        long minutes = timeInDay % 60;

        System.out.printf("%s\n%02d:%02d%n", DAYS[dayIndex], hours, minutes);
    }

    private static long toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

}
