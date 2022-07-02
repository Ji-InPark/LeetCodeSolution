import java.math.*;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int preh = 0, prew = 0;
        int maxh = 0, maxw = 0;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        for(int hori : horizontalCuts)
        {
            maxh = Math.max(maxh, hori - preh);
            preh = hori;
        }
        maxh = Math.max(maxh, h - preh);
        
        for(int verti : verticalCuts)
        {
            maxw = Math.max(maxw, verti - prew);
            prew = verti;
        }
        maxw = Math.max(maxw, w - prew);
        
        BigInteger b1 = BigInteger.valueOf(maxh);       
        BigInteger b2 = BigInteger.valueOf(maxw);       
        
        return b1.multiply(b2).remainder(BigInteger.valueOf(1000000007)).intValue();
    }
}