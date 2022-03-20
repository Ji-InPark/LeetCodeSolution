class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] t = new int[7];
        int[] b = new int[7];
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < tops.length; i++)
        {
            t[tops[i]]++;
            b[bottoms[i]]++;
        }
        
        for(int i = 1; i < t.length; i++)
        {
            if(t[i] + b[i] >= tops.length)
                arr.add(i);
        }
        
        int result = 20005;
        
        Loop:
        for(int i = 0; i < arr.size(); i++)
        {
            int now = arr.get(i);
            int tnum = 0, bnum = 0;
            for(int j = 0; j < tops.length; j++)
            {
                if(tops[j] == now && bottoms[j] == now) continue;
                else if(tops[j] == now && bottoms[j] != now) tnum++;
                else if(tops[j] != now && bottoms[j] == now) bnum++;
                else continue Loop;   
            }
            
            result = Math.min(result, Math.min(tnum, bnum));
        }
        
        if(result == 20005)
            result = -1;
        
        return result;
    }
}