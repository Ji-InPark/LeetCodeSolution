class Solution {
    public int strStr(String haystack, String needle) {
        return containsAt(haystack, needle);
    }
    
    public int containsAt(String match, String pattern) {
        int m = match.length(), n = pattern.length(), i = 0, j = 0;

        var lps = createLpsArray(pattern);

        while(i < m && j < n) {
            if(match.charAt(i) == pattern.charAt(j)) {
                i++; j++;
            } else if(j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return j == n ? (i - j) : -1;
    }

    private int[] createLpsArray(String str) {
        int[] lps = new int[str.length()];
        int length = 0, i = 1;

        while(i < lps.length) {
            if(str.charAt(i) == str.charAt(length)) {
                lps[i] = ++length;
                i++;
            } else {
                if(length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = length;
                    i++;
                }
            }
        }

        return lps;
    }
}