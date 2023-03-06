class Solution {
    public int findKthPositive(int[] arr, int k) {
        int result = 1;
        for(int i = 0; k > 0; result++) {
            if(i < arr.length && arr[i] == result) i++;
            else k--;
        }
        return --result;
    }
}