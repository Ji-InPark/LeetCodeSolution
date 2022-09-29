class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0, sum2 = 0;
        for(int i = 0; i < k; i++) {
            q.add(arr[i]);
            sum += Math.abs(arr[i] - x);
            sum += arr[i];
        }
        
        for(int i = k; i < arr.length; i++) {
            int tsum = sum, tsum2 = sum2;
            tsum2 -= q.peek();
            tsum2 += arr[i];
            
            tsum -= Math.abs(q.peek() - x);
            tsum += Math.abs(arr[i] - x);
            
            if(sum <= tsum && sum2 < tsum2) break;
            
            q.poll();
            q.add(arr[i]);
            sum = tsum;
            sum2 = tsum2;
            continue;
        }
        
        return (List)q;
    }
}