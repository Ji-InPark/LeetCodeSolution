class Solution {
    public String predictPartyVictory(String senate) {
        var dq = new LinkedList<Boolean>();
        for(var c: senate.toCharArray()) dq.add(c == 'D');

        int[] dr = new int[]{0, 0, 0};
        int flag = 3;
        while(flag == 3) {
            flag = 0;
            int size = dq.size();
            
            for(int i = 0; i < size; i++) {
                var now = dq.poll();
                int i1 = now ? 1 : 2;
                int i2 = now ? 2 : 1;
                
                if(dr[i2] > 0) {
                    dr[i2]--;
                    continue;
                }
                
                flag |= i1;
                dr[i1]++;
                dq.add(now);
            }
        }
        
        return flag == 1 ? "Dire" : "Radiant";
    }
}