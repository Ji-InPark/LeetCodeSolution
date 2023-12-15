class Solution {
    public String destCity(List<List<String>> paths) {
        var map = new HashMap<String, String>();
        
        for(var path: paths) {
            map.put(path.get(0), path.get(1));
        }
        
        var result = paths.get(0).get(0);
        
        while(map.containsKey(result)) {
            result = map.get(result);
        }
        
        return result;
    }
}