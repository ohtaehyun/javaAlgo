package programmers.level3.nPlus1CardGame;
import java.util.*;
class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        int n = cards.length + 1;
        Set<Integer> hands = new HashSet<>();
        Set<Integer> keeps = new HashSet<>();

        for (int i = 0; i < cards.length/3; i++) {
            hands.add(cards[i]);
        }

        int idx = cards.length/3;
        while(true) {
            answer += 1;
            if (idx == cards.length) break;

            keeps.add(cards[idx]);
            keeps.add(cards[idx+1]);
            int pairResult = findPair(hands, keeps, coin, n);
            if (pairResult > 0) break;
            coin += pairResult;
            idx += 2;
        }

        return answer;
    }

    private int findPair(Set<Integer> hands, Set<Integer> keeps, int coin, int n) {
        for (int h : hands) {
            if (hands.contains(n - h)) {
                hands.remove(h);
                hands.remove(n-h);
                return 0;
            }
        }

        if (coin < 1) return 1;

        for (int h : hands) {
            if (keeps.contains(n - h)) {
                hands.remove(h);
                keeps.remove(n-h);
                return -1;
            }
        }

        if (coin < 2) return 1;

        for (int k : keeps) {
            if (keeps.contains(n - k)) {
                keeps.remove(k);
                keeps.remove(n - k);
                return -2;
            }
        }

        return 1;
    }
}