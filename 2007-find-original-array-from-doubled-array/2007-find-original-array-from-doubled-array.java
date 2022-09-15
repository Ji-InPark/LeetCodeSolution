class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 == 1) return new int[0];
        
        Arrays.sort(changed);
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: changed) {
            if(map.getOrDefault(num * 2, 0) > 0) {
                map.put(num, map.get(num * 2) - 1);
                arr.add(num);
            } else if(num % 2 == 0 && map.getOrDefault(num / 2, 0) > 0) {
                map.put(num / 2, map.get(num / 2) - 1);
                arr.add(num / 2);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        if(arr.size() * 2 != changed.length) return new int[0];
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        
        return result;
    }
}