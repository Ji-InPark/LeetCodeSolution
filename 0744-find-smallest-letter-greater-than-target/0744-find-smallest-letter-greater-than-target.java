class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        var result = '~';
        for(var letter: letters) if(letter - target > 0 && letter - result < 0) result = letter;
        return result == '~' ? letters[0] : result;
    }
}