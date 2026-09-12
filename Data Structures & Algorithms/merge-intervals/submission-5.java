class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt((element) -> element[0]));
        int[] initInterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(initInterval);
        for ( int i = 1; i < intervals.length; i++ ){
            int[] curInterval = intervals[i];
            int curEnd = curInterval[1];
            int initEnd = initInterval[1];
            int curStart = curInterval[0];
            int initStart = initInterval[0];
            // [1, 3] [2, 4] or  [2, 6][4, 5] 
            // [1, 4] -> merge or [2, 6] -> drop curInterval
            if (initEnd >= curStart){
                // overlap confirmed, now check if we need to merge or drop
                    initInterval[1] = Math.max(curEnd, initEnd);
            } else {
                initInterval = curInterval;
                res.add(initInterval);
            }
        }
        return res.toArray(new int[res.size()][]);   
    }
}
