package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_27162 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice = new int[5];
        for (int i = 0; i < 3; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                dice[3] = i;
                dice[4] = j;

                if (s.charAt(0) == 'Y') {
                    result = Math.max(result, ones(dice));
                }

                if (s.charAt(1) == 'Y') {
                    result = Math.max(result, twos(dice));
                }

                if (s.charAt(2) == 'Y') {
                    result = Math.max(result, threes(dice));
                }

                if (s.charAt(3) == 'Y') {
                    result = Math.max(result, fours(dice));
                }

                if (s.charAt(4) == 'Y') {
                    result = Math.max(result, fives(dice));
                }

                if (s.charAt(5) == 'Y') {
                    result = Math.max(result, sixes(dice));
                }

                if (s.charAt(6) == 'Y') {
                    result = Math.max(result, fourOfAKind(dice));
                }

                if (s.charAt(7) == 'Y') {
                    result = Math.max(result, fullHouse(dice));
                }

                if (s.charAt(8) == 'Y') {
                    result = Math.max(result, littleStraight(dice));
                }

                if (s.charAt(9) == 'Y') {
                    result = Math.max(result, bigStraight(dice));
                }

                if (s.charAt(10) == 'Y') {
                    result = Math.max(result, yacht(dice));
                }

                if (s.charAt(11) == 'Y') {
                    result = Math.max(result, choice(dice));
                }
            }
        }
        System.out.print(result);
    }

    private static int ones(int[] array) {
        int result = 0;
        for (int j : array) {
            if (j == 1) {
                result += 1;
            }
        }
        return result;
    }

    private static int twos(int[] array) {
        int result = 0;
        for (int j : array) {
            if (j == 2) {
                result += 2;
            }
        }
        return result;
    }

    private static int threes(int[] array) {
        int result = 0;
        for (int j : array) {
            if (j == 3) {
                result += 3;
            }
        }
        return result;
    }

    private static int fours(int[] array) {
        int result = 0;
        for (int j : array) {
            if (j == 4) {
                result += 4;
            }
        }
        return result;
    }

    private static int fives(int[] array) {
        int result = 0;
        for (int j : array) {
            if (j == 5) {
                result += 5;
            }
        }
        return result;
    }

    private static int sixes(int[] array) {
        int result = 0;
        for (int j : array) {
            if (j == 6) {
                result += 6;
            }
        }
        return result;
    }

    private static int fourOfAKind(int[] array) {
        int result = 0;
        for (int i = 1; i <= 6; i++) {
            int count = 0;
            for (int j : array) {
                if (j == i) {
                    count++;
                }
            }
            if (count >= 4) {
                result = Math.max(result, 4 * i);
            }
        }
        return result;
    }

    private static int fullHouse(int[] array) {
        int result = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = i + 1; j <= 6; j++) {
                int iCount = 0;
                int jCount = 0;
                for (int k : array) {
                    if (k == i) {
                        iCount++;
                        continue;
                    }
                    if (k == j) {
                        jCount++;
                    }
                }

                if ((iCount == 3 && jCount == 2) || (iCount == 2 && jCount == 3)) {
                    result = Math.max(result, i * iCount + j * jCount);
                }
            }
        }
        return result;
    }

    private static int littleStraight(int[] array) {
        boolean[] appeared = new boolean[7];
        for (int i : array) {
            appeared[i] = true;
        }

        for (int i = 1; i <= 5; i++) {
            if (!appeared[i]) {
                return 0;
            }
        }
        return 30;
    }


    private static int bigStraight(int[] array) {
        boolean[] appeared = new boolean[7];
        for (int i : array) {
            appeared[i] = true;
        }
        for (int i = 2; i <= 6; i++) {
            if (!appeared[i]) {
                return 0;
            }
        }
        return 30;
    }

    private static int yacht(int[] array) {
        for (int i = 1; i <= 6; i++) {
            boolean isYacht = true;
            for (int j : array) {
                if (j != i) {
                    isYacht = false;
                    break;
                }
            }
            if (isYacht) {
                return 50;
            }
        }
        return 0;
    }

    private static int choice(int[] array) {
        int result = 0;
        for (int i : array) {
            result += i;
        }
        return result;
    }
}
