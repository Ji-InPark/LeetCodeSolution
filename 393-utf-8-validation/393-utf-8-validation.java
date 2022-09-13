class Solution {
    public boolean validUtf8(int[] data) {
        int num = 0, index = 0;
        
        while(index < data.length) {
            if((data[index] & 0x0000007f) == data[index]) {
                index++;
                continue;
            } else if((data[index] & 0x000000df) == data[index]) {
                num = 1;
            } else if((data[index] & 0x000000ef) == data[index]) {
                num = 2;
            } else if((data[index] & 0x000000f7) == data[index]) {
                num = 3;
            } else {
                return false;
            }

            index++;

            for(int i = 0; i < num; i++) {
                if(index + i >= data.length) return false;
                if((data[index + i] & 0x000000bf) != data[index + i] || (data[index + i] & 0x00000080) != 0x00000080) return false;
            }
            
            index += num;
        }
        
        return true;
    }
}