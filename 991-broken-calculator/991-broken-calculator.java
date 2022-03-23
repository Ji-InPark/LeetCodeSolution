class Solution {
    public int brokenCalc(int start, int target) {
        if(start >= target) return start - target;
        
        int result = 0;
        
        while(start < target)
        {
            if(target % 2 == 1)
            {
                target++;
                result++;
            }
            
            target /= 2;
            result++;
        }
        
        return result + start - target;
    }
}