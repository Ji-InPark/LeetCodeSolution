class Solution {
    public int maxDistance(int[] colors) {
        int[] arr = new int[105];
        for(int i = 0; i < colors.length; i++)
        {
            if(arr[i] != 0)
                continue;
            
            int diff = 0;
            for(int j = colors.length - 1; j > i; j--)
            {
                if(colors[i] != colors[j])
                {
                    diff = j - i;
                    break;
                }
            }
            
            if(diff != 0)
                arr[i] = diff;
        }
        
        int result = 0;
        for(int n : arr)
            result = Math.max(result, n);
        
        return result;
    }
}