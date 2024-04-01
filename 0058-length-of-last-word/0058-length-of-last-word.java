class Solution {
    public int lengthOfLastWord(String s) {
        return Arrays.stream(s.split(" ")).filter(str -> !str.isEmpty()).reduce((first, second) -> second).get().length();
    }
}