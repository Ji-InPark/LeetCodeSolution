class Solution {
    String input;
    ArrayList<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        input = s;
        if(s.length() > 12 || s.length() < 4) return result;
        
        solve(0, 0, "");
        
        return result;
    }
    
    public void solve(int start, int level, String ip) {
        if(level == 4 && start == input.length()) {
            result.add(ip.substring(0, ip.length() - 1));
            return;
        }
        if(level > 4 || start >= input.length()) return;
        
        if(input.charAt(start) == '0') {
            solve(start + 1, level + 1, ip + "0.");
        } else {
            for(int i = 1; i <= 3; i++){ 
                if(start + i > input.length()) continue;
                
                var substring = input.substring(start, start + i);
                
                if(Integer.parseInt(substring) <= 255) solve(start + i, level + 1, ip + substring + ".");
            }
        }
    }
}