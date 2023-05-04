class Solution {
    public String predictPartyVictory(String senate) {
        var dq = new ArrayDeque<Character>();
        for(var c: senate.toCharArray()) dq.add(c);

        int d = 0, r = 0, flag = 3;
        while(flag == 3) {
            flag = 0;
            int size = dq.size();
            
            for(int i = 0; i < size; i++) {
                if(dq.pollFirst() == 'D') {
                    flag |= 1;
                    if(r > 0) r--;
                    else {
                        d++;
                        dq.add('D');
                    }
                } else {
                    flag |= 2;
                    if(d > 0) d--;
                    else {
                        r++;
                        dq.add('R');
                    }
                }
            }
            
        }
        
        return flag == 1 ? "Dire" : "Radiant";
    }
}