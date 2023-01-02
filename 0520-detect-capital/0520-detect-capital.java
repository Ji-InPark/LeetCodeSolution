import java.util.regex.Pattern;

class Solution {
    public boolean detectCapitalUse(String word) {
        return Pattern.matches("[A-Z]+", word) || Pattern.matches("[a-z]+", word) || Pattern.matches("[A-Z][a-z]+", word);
    }
}