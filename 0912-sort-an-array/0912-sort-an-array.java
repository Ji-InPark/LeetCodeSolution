class Solution {
    int[] arr, tArr;
    public int[] sortArray(int[] nums) {
        arr = nums;
        tArr = new int[nums.length];
        sort(0, nums.length - 1);
        return arr;
    }
    
    public void sort(int left, int right) {
        int mid = left + (right - left) / 2;
        if(right - left > 1) {
            sort(left, mid);
            sort(mid + 1, right);
            merge(left, mid, mid + 1, right);
        } else {
            if(arr[left] > arr[right]) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }
    
    public void merge(int ls, int le, int rs, int re) {
        int li = ls, ri = rs;
        
        for(int i = 0; i < re - ls + 1; i++) {
            if(li <= le && ri <= re) 
                tArr[i] = arr[arr[li] < arr[ri] ? li++ : ri++];
            else if(li > ls && ri <= re) 
                tArr[i] = arr[ri++];
            else 
                tArr[i] = arr[li++];
        }
        
        for(int i = 0; i < re - ls + 1; i++) arr[ls + i] = tArr[i];
    }
}