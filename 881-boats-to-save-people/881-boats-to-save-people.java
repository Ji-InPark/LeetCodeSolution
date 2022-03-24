class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0;
        int left = 0, right = people.length - 1;
        
        while(right > left)
        {
            if(people[right--] + people[left] <= limit) left++;
            
            result++;
        }
        
        if(left == right)
            result++;
        
        return result;
    }
}