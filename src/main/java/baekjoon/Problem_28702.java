package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_28702 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int digit = -1;

        if (isDigit(a)) {
            digit = Integer.parseInt(a) + 3;
        } else if (isDigit(b)) {
            digit = Integer.parseInt(b) + 2;
        } else if (isDigit(c)) {
            digit = Integer.parseInt(c) + 1;
        }

        System.out.print(fizzbuzz(digit));
    }

    private static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String fizzbuzz(int digit) {
        boolean isMultiplesOfThree = digit % 3 == 0;
        boolean isMultiplesOfFive = digit % 5 == 0;

        if (isMultiplesOfThree && isMultiplesOfFive) {
            return "FizzBuzz";
        }
        if (isMultiplesOfThree) {
            return "Fizz";
        }
        if (isMultiplesOfFive) {
            return "Buzz";
        }
        return String.valueOf(digit);
    }
}
