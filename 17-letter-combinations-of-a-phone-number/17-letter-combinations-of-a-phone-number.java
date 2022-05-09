class Solution {
    String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return result;
        
        solve(0, digits, "");
        
        return result;
    }
    
    public void solve(int index, String digits, String combi)
    {
        if(index == digits.length())
        {
            result.add(combi);
        }
        else
        {
            int num = digits.charAt(index) - '0';
            
            for(int i = 0; i < arr[num].length(); i++)
            {
                solve(index + 1, digits, combi + arr[num].charAt(i));
            }
        }
    }
}