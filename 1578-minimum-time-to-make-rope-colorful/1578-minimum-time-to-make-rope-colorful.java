class Solution {
    public int minCost(String colors, int[] neededTime) {
        int result = 0, left = 0;
        for(int i = 1; i < colors.length(); i++) {
            if(colors.charAt(left) == colors.charAt(i)) {
                if(neededTime[left] < neededTime[i]) {
                    result += neededTime[left];
                    left = i;
                } else {
                    result += neededTime[i];
                }
            } else {
                left = i;
            }
        }
        
        return result;
    }
}