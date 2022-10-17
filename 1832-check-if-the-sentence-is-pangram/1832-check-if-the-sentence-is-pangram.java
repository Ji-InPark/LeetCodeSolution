class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        int result = 0;
        for(var c : sentence.toCharArray()) if(arr[c - 'a']++ == 0) result++;
        return result == 26;
    }
}