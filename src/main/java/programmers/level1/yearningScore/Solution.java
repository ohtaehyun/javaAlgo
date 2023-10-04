package programmers.level1.yearningScore;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> yearningByName = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            yearningByName.put(name[i], yearning[i]);
        }

        for (String[] photoNames:
             photo) {
            int score = 0;
            for (String n:
                 photoNames) {
                score += yearningByName.getOrDefault(n, 0);
            }
            answer.add(score);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
