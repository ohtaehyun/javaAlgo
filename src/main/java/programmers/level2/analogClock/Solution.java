package programmers.level2.analogClock;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = toSeconds(h1, m1, s1);
        int end = toSeconds(h2, m2, s2);
        //정각인 경우에는 어쨋든 1번 알람이 울리고 시작하는 경우 ex 1, 0, 0 , 1, 0, 1인 경우에도 1번 알람이 울리는 경우 (시작할 때)
        int oClockCase = start % 3600 == 0 ? 1 : 0;

        return countAlarm(end) - countAlarm(start) + oClockCase;
    }

    //0초부터 해당 초까지 울리는 알람의 개수
    public int countAlarm(int seconds) {
        //초침의 회전주기는 60초, 분침의 회전주기는 3600초, 만나는 횟수가 59번 (59분에서 00분으로 갈때는 00분에서 만남)
        int mCount = (seconds * 59) / 3600;
        //초침의 회전주기는 60초, 시침의 회전주기는 43200초, 만나는 횟수가 719번 (11시 59분에서 12시 00분으로 갈때는 00분에서 만남)
        int hCount = (seconds * 719) / 43200;
        //만나는 횟수 59와 719에 대해서는 0, 0, 0, 1, 0, 0 -> 119 와 0, 0, 0, 1, 1, 0 -> 120의 경우의 수를 확인해보면 확실히 알 수 있다.

        //12시 0분 0초에는 mCount와 hCount가 같이 오르기 때문에 예외처리 23시59분59초가 입력제한이라 86400의 경우는 고려x
        int dupCase = (seconds >= 43200 ? 1 : 0);
        int zeroCase = 1;
        int total = mCount + hCount - dupCase + zeroCase;
        System.out.println("seconds: "+ seconds + " mCount: "+ mCount + " hCount: " + hCount +" dupCase: " + dupCase + " total: " + total);
        return total;
    }

    public int toSeconds(int h, int m, int s) {
        return 60 * 60 * h + 60 * m + s;
    }
}
