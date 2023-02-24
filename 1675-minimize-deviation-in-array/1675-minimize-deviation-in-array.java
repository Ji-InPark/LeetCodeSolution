class Solution {
    public int minimumDeviation(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int num : nums) {
            if(num % 2 == 1) num *= 2;
            
            min = Math.min(min, num);
            max = Math.max(max, num);
            
            pq.add(num);
        }
        
        result = max - min;
        
        while(pq.peek() % 2 == 0) {
            int num = pq.poll();
            
            result = Math.min(result, num - min);
            
            num /= 2;
            
            min = Math.min(min, num);
            
            pq.add(num);
        }
        
        result = Math.min(result, pq.poll() - min);
        
        return result;
    }

}