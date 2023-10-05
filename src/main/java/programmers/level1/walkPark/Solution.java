package programmers.level1.walkPark;

import java.util.HashMap;

public class Solution {
    public int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();
        HashMap<String, int[]> directions = new HashMap<>();

        directions.put("E", new int[] {0, 1});
        directions.put("W", new int[] {0, -1});
        directions.put("N", new int[] {-1, 0});
        directions.put("S", new int[] {1, 0});

        int[] now = {0, 0};

        for (String p : park) {
            int index = p.indexOf('S');
            if (index >= 0) {
                now[1] = index;
                break;
            }
            now[0]++;
        }

        for (String route :
                routes) {
            String[] splited = route.split(" ");
            int[] direction = directions.get(splited[0]);
            int repeat = Integer.parseInt(splited[1]);
            boolean hasBlock = false;
            int nx = now[0];
            int ny = now[1];
            for (int i = 0; i < repeat && hasBlock == false; i++) {
                nx += direction[0];
                ny += direction[1];

                if (nx < 0 || nx >= height || ny < 0 || ny >= width || park[nx].charAt(ny) == 'X') {
                    hasBlock = true;
                }
            }

            if (hasBlock == false) {
                now = new int[] {nx, ny};
            }
        }

        return now;
    }
}
