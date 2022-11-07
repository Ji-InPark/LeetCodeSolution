class Solution {
    public int maximum69Number (int num) {
        int result = 0, std = 1;
        boolean flag = true;
        
        while(num / std > 0) std *= 10;
        std /= 10;
        
        while(std > 0) {
            int temp = num / std;
            
            if(temp == 6 && flag) {
                flag = false;
                temp = 9;
            }
            
            result = result * 10 + temp;
            num %= std;
            std /= 10;
        }
        
        return result;
    }
}