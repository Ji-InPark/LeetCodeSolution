class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<Integer>();
        int next = 0;
        
        for(int i = num.length - 1; i >= 0; i--)
        {
            int sum = num[i] + (k % 10) + next;
            result.add(0, sum % 10);
            next = sum / 10;
            k /= 10;
        }
        
        while(k > 0)
        {
            int sum = (k % 10) + next;
            result.add(0, sum % 10);
            next = sum / 10;
            k /= 10;
        }
        
        if(next > 0)
            result.add(0, next);
        
        return result;
    }
}