class Solution {
    public String addBinary(String a, String b) {
        var sa = new StringBuilder(a).reverse();
        var sb = new StringBuilder(b).reverse();
        var result = new StringBuilder();
        int pre = 0;
        
        for(int i = 0; i < Math.max(sa.length(), sb.length()); i++) {
            int sum = pre;
            if(i < sa.length() && sa.charAt(i) == '1') sum++;
            if(i < sb.length() && sb.charAt(i) == '1') sum++;
            
            pre = sum / 2;
            sum %= 2;
            result.append(sum == 1 ? '1' : '0');
        }
        
        if(pre == 1) result.append('1');
        
        return result.reverse().toString();
    }
}