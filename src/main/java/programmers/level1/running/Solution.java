package programmers.level1.running;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);            
        }

        for (String calling: callings) {
            int now = playerMap.get(calling);
            int next = now - 1;
            playerMap.replace(calling, next);

            String player = players[next];
            playerMap.replace(player, now);

            String temp = players[now];
            players[now] = players[next];
            players[next] = temp;
        }

        return players;
    }
}
