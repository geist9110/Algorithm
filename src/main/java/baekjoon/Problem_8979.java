package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_8979 implements ProblemInterface {

    private static class Country {

        int gold;
        int silver;
        int bronze;

        public Country(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Country> countries = new ArrayList<>();
        Country findCountry = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            if (Integer.parseInt(st.nextToken()) == K) {
                findCountry = new Country(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                );
                countries.add(findCountry);
                continue;
            }

            countries.add(
                new Country(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                )
            );
        }

        int rank = 1;
        for (int i = 0; i < countries.size(); i++) {
            Country country = countries.get(i);
            if (country.gold > findCountry.gold) {
                rank++;
                continue;
            }

            if (country.gold == findCountry.gold &&
                country.silver > findCountry.silver) {
                rank++;
                continue;
            }

            if (country.gold == findCountry.gold &&
                country.silver == findCountry.silver &&
                country.bronze > findCountry.bronze) {
                rank++;
            }
        }

        System.out.print(rank);
    }
}
