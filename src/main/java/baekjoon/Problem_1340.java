package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1340 implements ProblemInterface {

    private static final int[] DAYS_IN_MONTH = {
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] date = br.readLine().split(" ");
        String month = date[0];
        int day = Integer.parseInt(date[1].substring(0, 2));
        int year = Integer.parseInt(date[2]);
        boolean isLeapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        int hour = Integer.parseInt(date[3].substring(0, 2));
        int minute = Integer.parseInt(date[3].substring(3, 5));

        double totalTime = getTotalTime(isLeapYear);
        double passedTime = getPassedTime(month, day, hour, minute, isLeapYear);

        System.out.print(passedTime / totalTime * 100);
    }

    private static double getTotalTime(boolean isLeapYear) {
        return isLeapYear ? 366 * 24 * 60 : 365 * 24 * 60;
    }

    private static double getPassedTime(
        String month,
        int day,
        int hours,
        int minutes,
        boolean isLeapYear
    ) {
        int passedDays = 0;
        int monthIndex = getMonthIndex(month);
        for (int i = 0; i < monthIndex; i++) {
            passedDays += DAYS_IN_MONTH[i];
        }
        passedDays += day - 1;
        if (isLeapYear && monthIndex > 1) {
            passedDays++;
        }

        return passedDays * 24 * 60 + hours * 60 + minutes;
    }

    private static int getMonthIndex(String month) {
        if (month.equals("January")) {
            return 0;
        }

        if (month.equals("February")) {
            return 1;
        }

        if (month.equals("March")) {
            return 2;
        }

        if (month.equals("April")) {
            return 3;
        }

        if (month.equals("May")) {
            return 4;
        }

        if (month.equals("June")) {
            return 5;
        }

        if (month.equals("July")) {
            return 6;
        }

        if (month.equals("August")) {
            return 7;
        }

        if (month.equals("September")) {
            return 8;
        }

        if (month.equals("October")) {
            return 9;
        }

        if (month.equals("November")) {
            return 10;
        }

        return 11;
    }
}
