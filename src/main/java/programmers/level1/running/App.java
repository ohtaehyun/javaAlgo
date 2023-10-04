package programmers.level1.running;

public class App {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = sol.solution(players, callings);
        System.out.println("result = " + result);
    }
}
