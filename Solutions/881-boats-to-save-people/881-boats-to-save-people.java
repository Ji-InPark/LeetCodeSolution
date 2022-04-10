class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] arr = new int[limit + 1];
        int result = 0;
        int left = 0, right = people.length - 1;
        
        for(int num : people)
            arr[num]++;
        
        int index = 1;
        
        for(int i = 0; i < people.length; i++)
        {
            while(arr[index] == 0) index++;
            
            arr[index]--;
            
            people[i] = index;
        }
        
        while(left < right)
        {
             if(people[right--] + people[left] <= limit) left++;
            
            result++;
        }
        
        if(left == right)
            result++;
        
        return result;
    }
}