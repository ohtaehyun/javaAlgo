package programmers.level1.walkPark;

public class App {
    public static void main(String[] args) {
//        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] park = {"SOO","OOO","OOO"};
//        String[] walk = {"E 2","S 3","W 1"};
        String[] walk = {"E 2","S 2","W 1"};

        Solution solution = new Solution();
        int[] result = solution.solution(park, walk);
        System.out.println("result = " + result[0] + result[1]);
    }
}
