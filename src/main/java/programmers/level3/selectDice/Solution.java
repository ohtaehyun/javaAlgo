package programmers.level3.selectDice;
import java.util.*;

class Solution {
    private int[] answer;
    private int maxWinCount = 0;

    public int[] solution(int[][] dice) {
        boolean[] visited = new boolean[dice.length]; //주사위중 선택 여부
        answer = new int[dice.length/2];

        combination(visited, 0, dice.length/2, dice);
        return answer;
    }

    private void combination(boolean[] visited, int start, int remain, int[][] dice) {
        if (remain == 0) {
            calculateWinCount(visited, dice); // 선택된 주사위를 기반으로 승수 계산
            return;
        }
        for (int s = start; s < dice.length; s++) {
            visited[s] = true;
            combination(visited, s+1, remain-1, dice);
            visited[s] = false;
        }
    }

    private void calculateWinCount(boolean[] visited, int[][] dice) {
        int[] aSum = new int[] {0};
        int[] bSum = new int[] {0};

        for (int i = 0; i < visited.length; i ++) {
            if (visited[i]) {
                aSum = getSum(aSum, dice[i]);
            } else {
                bSum = getSum(bSum, dice[i]);
            }
        }

        int winCount = 0;
        ArrayList<Integer[]> aDigest = digestSum(aSum);
        ArrayList<Integer[]> bDigest = digestSum(bSum);

        for (Integer[] a : aDigest) {
            int aNum = a[0];
            int aCount = a[1];

            for (Integer[] b : bDigest) {
                int bNum = b[0];
                int bCount = b[1];

                if (aNum > bNum) winCount += aCount * bCount;
            }
        }

        if (maxWinCount < winCount) {
            maxWinCount = winCount;
            int idx = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) answer[idx++] = i+1;
            }
        }
    }

    private int[] getSum(int[] score, int[] dice) {
        int[] sum = new int[score.length * dice.length];

        for(int i = 0; i < score.length; i++) {
            for(int j = 0; j < dice.length; j++) {
                sum[(i * dice.length) + j] = score[i] + dice[j];
            }
        }
        return sum;
    }

    private ArrayList<Integer[]> digestSum(int[] sum) { //중복해서 등장하는 주사위 눈을 축약시키기 우리가 알고싶은건 경우의 수
        ArrayList<Integer[]> digestedDice = new ArrayList<>();
        List<Integer> diceNums = new ArrayList<>();
        for(int s : sum) {
            diceNums.add(s);
        }
        Set<Integer> set = new HashSet<>(diceNums);
        for (int s : set) {
            digestedDice.add(new Integer[] {s, Collections.frequency(diceNums, s)});
        }
        return digestedDice;
    }
}