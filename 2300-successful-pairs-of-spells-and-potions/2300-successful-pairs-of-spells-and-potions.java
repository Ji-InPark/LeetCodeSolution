class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        
        for(int i = 0; i < spells.length; i++) {
            int left = 0, right = potions.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                
                if((long)potions[mid] * (long)spells[i] < success) left = mid + 1;
                else right = mid - 1;
            }
            
            spells[i] = potions.length - right - 1;
        }
        
        return spells;
    }
}