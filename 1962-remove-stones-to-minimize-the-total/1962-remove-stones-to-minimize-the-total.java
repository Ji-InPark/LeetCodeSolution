class Solution {
    public int minStoneSum(int[] piles, int k) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        var result = 0;
        
        for(var pile: piles) {
            pq.add(pile);
            result += pile;
        }
        
        while(k-- > 0) {
            var num = pq.poll();
            result -= num / 2;
            pq.add(num - num / 2);
        }
        
        return result;
    }
}