package programmers.level2.oilDrilling;
import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int[] answers = new int[land[0].length];
        boolean[][] visited = new boolean[land.length][land[0].length];

        for (int y = 0; y < land[0].length; y++) {
            for (int x = 0; x < land.length; x++) {
                if (land[x][y] != 0 && !visited[x][y]) {
                    OilGroup oilGroup = bfs(x, y, land, visited);
                    for (int column : oilGroup.getColumns()) {
                        answers[column] += oilGroup.getSum();
                    }
                }
            }
        }

        return Arrays.stream(answers).max().orElse(0);
    }

    private OilGroup bfs(int x, int y, int[][] land, boolean[][] visited) {
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        visited[x][y] = true;

        Set<Integer> columns = new HashSet<>();
        columns.add(y);
        int oilCnt = 1;

        while(!queue.isEmpty()) {
            int[] position = queue.poll();
            int nowX = position[0];
            int nowY = position[1];

            for(int[] direction : directions) {
                int nx = nowX + direction[0];
                int ny = nowY + direction[1];
                if (0 <= nx && nx < land.length && 0 <= ny && ny < land[0].length && !visited[nx][ny] && land[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    oilCnt++;
                    if (ny > y) columns.add(ny);
                }
            }
        }

        return new OilGroup(oilCnt, columns);
    }
}

class OilGroup {
    private int sum;
    private Set<Integer> columns;

    public OilGroup(int sum, Set<Integer> columns) {
        this.sum = sum;
        this.columns = columns;
    }

    public int getSum() {
        return sum;
    }

    public Set<Integer> getColumns() {
        return columns;
    }
}