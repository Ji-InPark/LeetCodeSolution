class Solution {
public:
    bool isSubsequence(string s, string t) {
        int index = 0;
        for(int i = 0; i < t.length(); i++)
        {
            if(s[index] == t[i])
                index++;
            
            if(index == s.length())
                break;
        }
        
        return index == s.length();
    }
};