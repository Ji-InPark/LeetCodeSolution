class Solution {
    fun reverseWords(s: String): String {
        return s.split(" ").reversed().filter{!it.equals("")}.joinToString(" ");
    }
}