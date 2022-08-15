class Solution {
    public int romanToInt(String s) {
        s += " ";
        int index = 0, result = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("IV", 4); map.put("IX", 9); map.put("XL", 40); map.put("XC", 90); map.put("CD", 400); map.put("CM", 900);
        map.put("I", 1); map.put("V", 5); map.put("X", 10); map.put("L", 50); map.put("C", 100); map.put("D", 500); map.put("M", 1000);
        while(index < s.length() - 1) {
            if(map.containsKey(s.substring(index, index + 2))) {
                result += map.get(s.substring(index, index + 2));
                index += 2;
            } else {
                result += map.get(s.substring(index, index + 1));
                index++;
            }
        }
        
        return result;
    }
}