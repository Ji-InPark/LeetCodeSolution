class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        
        var arr = new StringBuilder[numRows + 1];
        for(int i = 0; i <= numRows; i++) arr[i] = new StringBuilder();
        int index = 1, dir = -1;
        
        for(var c: s.toCharArray()) {
            if(index == 1 || index == numRows) dir *= -1;
            arr[index].append(c);
            index += dir;
        }
        
        for(int i = 1; i <= numRows; i++) arr[0].append(arr[i].toString());
        
        return arr[0].toString();
    }
}