class Solution {
    public int numberOfSteps(int num) {
        int result = 0;
        for(;num > 0; result++) num -= num % 2 == 0 ? num / 2 : 1;
        return result;
    }
}