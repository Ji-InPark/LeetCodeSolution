class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        for(int i = 0; i < k; i++) {
            q.add(arr[i]);
            sum += Math.abs(arr[i] - x);
        }
        
        for(int i = k; i < arr.length; i++) {
            int num = Math.abs(arr[i] - x) - Math.abs(q.peek() - x);

            if(0 <= num && q.peek() < arr[i]) break;
            
            q.poll();
            q.add(arr[i]);
            sum += num;
            continue;
        }
        
        return (List)q;
    }
}