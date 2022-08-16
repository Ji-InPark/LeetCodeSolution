class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a']++ == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            if(arr[s.charAt(q.peek()) - 'a'] == 1) return q.poll();
            q.poll();
        }
        
        return -1;
    }
}