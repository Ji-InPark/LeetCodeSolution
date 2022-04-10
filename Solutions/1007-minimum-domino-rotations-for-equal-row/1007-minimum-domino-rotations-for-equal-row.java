class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] t = new int[7];
        int[] b = new int[7];
        
        for(int i = 0; i < tops.length; i++)
        {
            t[tops[i]]++;
            b[bottoms[i]]++;
        }
        
        int result = 20005;
        
        Loop:
        for(int i = 1; i < t.length; i++)
        {
            if(t[i] + b[i] >= tops.length)
            {
                int tnum = 0, bnum = 0;
                for(int j = 0; j < tops.length; j++)
                {
                    if(tops[j] == i && bottoms[j] == i) continue;
                    else if(tops[j] == i && bottoms[j] != i) tnum++;
                    else if(tops[j] != i && bottoms[j] == i) bnum++;
                    else continue Loop;   
                }
                
                result = Math.min(result, Math.min(tnum, bnum));
            }
        }
        
        if(result == 20005)
            result = -1;
        
        return result;
    }
}