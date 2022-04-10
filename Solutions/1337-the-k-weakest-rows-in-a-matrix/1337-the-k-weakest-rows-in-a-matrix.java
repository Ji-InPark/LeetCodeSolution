class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        pair[] arr = new pair[mat.length];
        int[] result = new int[k];
        
        for(int i = 0; i < mat.length; i++)
        {
            int sum = 0;
            for(int num : mat[i]) sum += num;
            arr[i] = new pair(sum, i);
        }
        
        Arrays.sort(arr, (p1, p2) -> {return p1.val == p2.val ? p1.index - p2.index : p1.val - p2.val;});
        
        for(int i = 0; i < k; i++)
            result[i] = arr[i].index;
        
        return result;
    }
}

class pair
{
    int val, index;
    
    public pair(int val, int index)
    {
        this.val = val;
        this.index = index;
    }
}