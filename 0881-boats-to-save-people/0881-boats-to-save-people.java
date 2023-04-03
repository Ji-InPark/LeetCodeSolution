class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0, left = 0;
        
        for(int right = people.length - 1; right >= left; right--) {
            if(people[left] <= limit - people[right]) left++;
            
            result++;
        }
        
        return result;
    }
}