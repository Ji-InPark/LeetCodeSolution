class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            System.out.println(left + " " + mid + " " + right);
            
            if(mid == 0) mid++;
            else if(mid == arr.length - 1) mid--;
            
            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) return mid;
            
            if(arr[mid - 1] < arr[mid]) left = mid + 1;
            else right = mid - 1;            
        }
        
        return -1;
    }
}