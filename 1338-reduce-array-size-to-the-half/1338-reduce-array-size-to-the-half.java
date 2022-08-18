class Solution {
    public int minSetSize(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] cnt = new int[100004];
        
        for(int num : arr) pq.add(new Pair(num, ++cnt[num]));
        
        int sum = 0, result = 0;
        HashSet<Integer> set = new HashSet<>();
        
        while(sum < (arr.length + 1) / 2) {
            Pair now = pq.poll();
            if(set.contains(now.num)) continue;
            sum += now.count;
            set.add(now.num);
            result++;
        }
        
        return result;
    }
    
    public class Pair implements Comparable<Pair>{    
        int num, count;
        
        public Pair(int num, int count){
            this.num = num;
            this.count = count;
        }
        
        @Override
        public int compareTo(Pair o) {
            return o.count - this.count;
        }
    }
}