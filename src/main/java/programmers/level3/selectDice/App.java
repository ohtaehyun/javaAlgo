package programmers.level3.selectDice;

public class App {
    public static void main(String[] args) {
        int[][] test = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}, {1, 1, 4, 4, 5, 5}, {1, 1, 4, 4, 5, 5}, {1, 1, 4, 4, 5, 5}, {1, 1, 4, 4, 5, 5}};

        Solution solution = new Solution();
        int[] answer = solution.solution(test);
        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
