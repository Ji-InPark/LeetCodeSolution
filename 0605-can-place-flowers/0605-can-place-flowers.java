class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1) return (flowerbed[0] == 0 ? 1 : 0) >= n;
        if(flowerbed.length + 1 / 2 < n) return false;
        
        int sum = 0;
        if(flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            sum++;
        }
        
        if(flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            sum++;
        }
        
        for(int i = 1; i < flowerbed.length - 1 && sum < n; i++) {
            if(flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                sum++;
            }
        }
        
        return sum >= n;
    }
}