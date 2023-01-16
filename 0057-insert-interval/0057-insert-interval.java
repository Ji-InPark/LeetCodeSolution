class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][] {newInterval};
        
        var list = new ArrayList<int[]>();
        var temp = new ArrayList<int[]>();
        
        for(var itv: intervals) list.add(itv);
        
        for(int i = intervals.length - 1; i >= 0; i--) {
            if(list.get(i)[0] <= newInterval[0]) {
                list.add(i + 1, newInterval);
                break;
            }
        }
        
        if(list.size() == intervals.length) list.add(0, newInterval);
        
        
        int index = 0;
        temp.add(list.get(0));
        for(int i = 1; i < list.size(); i++) {
            var prev = temp.get(index);
            var now = list.get(i);
            
            if(prev[1] < now[0]) {
                temp.add(now);
                index++;
            } else {
                prev[0] = Math.min(prev[0], now[0]);
                prev[1] = Math.max(prev[1], now[1]);
            }
        }
        
        var result = new int[temp.size()][2];
        for(int i = 0; i < temp.size(); i++) result[i] = temp.get(i);
        
        return result;
    }
}